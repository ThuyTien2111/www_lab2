<%@ page import="vn.edu.iuh.fit.convert.ProductPricePath" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.service.ProductService" %>
<%@ page import="vn.edu.iuh.fit.models.OrderDetail" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vn.edu.iuh.fit.frontEndModel.OrderModel" %>
<%@ page import="vn.edu.iuh.fit.service.OrderService" %>
<%@ page import="vn.edu.iuh.fit.service.OrderDetailService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trang bán hàng</title>
    <!-- Thêm các tài nguyên Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Thêm CSS tùy chỉnh -->
    <style>
        .product-image {
            width: 200px;
            height: 150px;
        }
        .cart {
            position: fixed;
            top: 20px;
            right: 20px;
            background-color: #fff;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        .pagination {
            margin-top: 20px;
        }
        /* Thêm CSS cho form thêm sản phẩm */
        .add-product-form {
            display: none;
            position: fixed;
            top: 50%;
            left: 50%;
            padding:40px;
            transform: translate(-50%, -50%);
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            max-height: 80%; /* Giới hạn chiều cao tối đa của form */
            overflow-y: auto; /* Tạo thanh cuộn dọc khi nội dung quá dài */
        }
        .cancel-button {
            position: absolute;
            top: 10px;
            right: 10px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Danh sách sản phẩm</h1>

    <!-- Danh sách sản phẩm -->
    <div class="row" id="product-list">
        <%
            ProductService productService = new ProductService();
            List<ProductPricePath> products = productService.getProductPricePaths();

            // Phân trang (3 sản phẩm trên 1 trang)
            int itemsPerPage = 3;
            int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
            int startIdx = (currentPage - 1) * itemsPerPage;
            int endIdx = Math.min(startIdx + itemsPerPage, products.size());

            List<ProductPricePath> currentProducts = products.subList(startIdx, endIdx);
            for (ProductPricePath product : currentProducts) {
        %>
        <div class="col-md-4 mb-4">
            <div class="card">
                <img src="<%= product.getPath() %>" alt="Hình ảnh sản phẩm" class="card-img-top product-image">
                <div class="card-body">
                    <h5 class="card-title"><%= product.getName() %></h5>
                    <p class="card-text"><%= product.getPrice() %> $</p>
                    <!-- Thêm nút hiển thị form thêm sản phẩm -->
                    <button class="btn btn-success text-white"
                            data-product-id="<%= product.getProductID() %>"
                            data-product-name="<%= product.getName() %>"
                            onclick="showAddProductForm(this)">
                        Thêm sản phẩm
                    </button>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>

    <!-- Phân trang -->
    <div class="pagination">
        <ul class="pagination justify-content-center">
            <%
                int totalPages = (int) Math.ceil((double) products.size() / itemsPerPage);
                for (int i = 1; i <= totalPages; i++) {
            %>
            <li class="page-item <%= (i == currentPage) ? "active" : "" %>">
                <a class="page-link" href="?page=<%= i %>"><%= i %></a>
            </li>
            <%
                }
            %>
        </ul>
    </div>
    <!-- Thêm nút Vào chế độ quản trị viên và căn phải nút -->
    <div class="row justify-content-end mt-4">
        <div class="col-md-4 text-right">
            <a href="employee.jsp" class="btn btn-warning">Vào chế độ quản trị viên</a>
        </div>
    </div></div>

<!-- Hiển thị danh sách sản phẩm trong giỏ hàng -->
<div class="cart">
    <h4>Giỏ hàng</h4>
    <ul id="cart-items">
        <%
            //long orderCode = (Long) request.getAttribute("orderCode");
//            OrderDetailService service= new OrderDetailService();
            List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetails");
            if (orderDetails != null && !orderDetails.isEmpty()) {
                for (OrderDetail orderDetail : orderDetails) {
        %>
        <li><%= orderDetail.getProduct().getName() %> - <%= (int)orderDetail.getQuantity() %> sản phẩm</li>
        <%
            }
        } else {
        %>
        <li>Giỏ hàng trống</li>
        <%
            }
        %>
    </ul>
    <%
        if (orderDetails != null && !orderDetails.isEmpty()) {
    %>
    <form action="productsControll?action=caclPrice&orderCode=<%=orderDetails.get(0).getOrder().getOrder_id()%>" method="post">
        <button  class="btn btn-primary" type="submit">Thanh toán</button>
    </form>
    <%
    } else {
    %>
    <button id="checkout-btn" class="btn btn-primary" >
        Thanh toán
    </button>
    <%
        }
    %>

</div>

<!-- Form thêm sản phẩm -->
<div class="container add-product-form">
    <div class="cancel-button" onclick="hideAddProductForm()">X</div>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2>Thêm sản phẩm</h2>
            <form action="productsControll?action=addOrder" method="post">
                <div class="form-group">
                    <label for="productNameInput">Tên sản phẩm:</label>
                    <input type="text" name="productName" id="productNameInput" class="form-control" readonly>
                </div>
                <div class="form-group">
                    <label for="productIDInput">Mã sản phẩm:</label>
                    <input type="text" name="productID" id="productIDInput" class="form-control" readonly>
                </div>
                <div class="form-group">
                    <label for="quantityInput">Số lượng:</label>
                    <input type="number" name="quantity" id="quantityInput" class="form-control">
                </div>
                <div class="form-group">
                    <label for="orderCodeInput">Mã đơn hàng:</label>
                    <input type="text" name="orderCode" id="orderCodeInput" class="form-control">
                </div>
                <div class="form-group">
                    <label for="employeeCodeInput">Mã nhân viên:</label>
                    <input type="text" name="employeeCode" id="employeeCodeInput" class="form-control">
                </div>
                <div class="form-group">
                    <label for="customerCodeInput">Mã khách hàng:</label>
                    <input type="text" name="customerCode" id="customerCodeInput" class="form-control">
                </div>
                <div class="form-group">
                    <label for="noteInput">Ghi chú:</label>
                    <input type="text" name="note" id="noteInput" class="form-control">
                </div>
                <button type="submit" class="btn btn-primary">Đặt hàng</button>
            </form>
        </div>
    </div>
</div>

<!-- Thêm mã JavaScript để quản lý hiển thị form thêm sản phẩm -->
<script>
    function showAddProductForm(button) {
        var form = document.querySelector('.add-product-form');
        var productNameInput = document.querySelector('#productNameInput');
        var productIDInput = document.querySelector('#productIDInput');
        var productId = button.getAttribute('data-product-id');
        var productName = button.getAttribute('data-product-name');

        // Thiết lập giá trị trường nhập liệu
        productNameInput.value = productName;
        productIDInput.value= productId;

        form.style.display = 'block';
    }
    function hideAddProductForm() {
        var form = document.querySelector('.add-product-form');
        form.style.display = 'none';
    }
</script>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Danh sách sản phẩm</h1>

    <!-- Hiển thị danh sách sản phẩm -->
    <div class="row">
        <%--        <%--%>
        <%--            // Lấy danh sách sản phẩm từ CSDL hoặc một nguồn dữ liệu khác--%>
        <%--            List<Product> productList = productService.getProductList();--%>

        <%--            for (Product product : productList) {--%>
        <%--        %>--%>
        <div class="col-md-4 mb-4">
            <div class="card">
                <div class="card-body">
                    <%--                    <h5 class="card-title"><%= product.getName() %></h5>--%>
                    <h5 class="card-title">Product Name 1</h5>

                    <%--    <p class="card-text">Price: <%= product.getPrice() %> VND</p>--%>
                    <p class="card-text">Price: 100000 VND</p>

                    <form method="POST" action="CartServlet">
                        <%--                        <input type="hidden" name="productId" value="<%= product.getId() %>">--%>
                        <input type="hidden" name="productId" value="p1">

                        <input type="submit" class="btn btn-primary" value="Thêm vào giỏ hàng">
                    </form>
                </div>
            </div>
        </div>
        <%--        <%--%>
        <%--            }--%>
        <%--        %>--%>
    </div>

    <!-- Hiển thị giỏ hàng -->
    <h2>Giỏ hàng</h2>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Giá</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <%--        <%--%>
        <%--            // Lấy danh sách sản phẩm trong giỏ hàng từ session--%>
        <%--            List<Product> cartItems = (List<Product>) session.getAttribute("cartItems");--%>

        <%--            if (cartItems != null && !cartItems.isEmpty()) {--%>
        <%--                for (Product item : cartItems) {--%>
        <%--        %>--%>
        <tr>
            <%--            <td><%= item.getName() %></td>--%>
            <%--            <td><%= item.getPrice() %> VND</td>--%>
            <td>Item 1</td>
            <td>100000 VND</td>
            <td>
                <form method="POST" action="CartServlet">
                    <%--                    <input type="hidden" name="productId" value="<%= item.getId() %>">--%>
                    <input type="hidden" name="productId" value="item1">
                    <input type="hidden" name="action" value="remove">
                    <input type="submit" class="btn btn-danger" value="Xóa">
                </form>
            </td>
        </tr>
        <%--        <%--%>
        <%--            }--%>
        <%--        } else {--%>
        <%--        %>--%>
        <tr>
            <td colspan="3">Giỏ hàng trống</td>
        </tr>
        <%--        <%--%>
        <%--            }--%>
        <%--        %>--%>
        </tbody>

    </table>
    <input type="submit" class="btn btn-primary" value="Thanh toán">
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.0/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
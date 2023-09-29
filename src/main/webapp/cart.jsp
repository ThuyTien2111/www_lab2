<%@ page import="vn.edu.iuh.fit.models.OrderDetail" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
    <!-- Thêm các tài nguyên Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4">Danh sách sản phẩm trong giỏ hàng</h1>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Tên sản phẩm</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Thành tiền</th>
        </tr>
        </thead>
        <tbody>
        <%
            // Retrieve orderDetails using scriptlet
            List<OrderDetail> orderDetails = (List<OrderDetail>) request.getAttribute("orderDetails");
            if (orderDetails != null && !orderDetails.isEmpty()) {
                for (OrderDetail orderDetail : orderDetails) {
        %>
        <tr>
            <td><%= orderDetail.getProduct().getName() %></td>
            <td><%= (int)orderDetail.getQuantity() %></td>
            <td><%= orderDetail.getPrice() %></td>
            <td><%= orderDetail.getPrice()*orderDetail.getQuantity() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="4">Giỏ hàng trống</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>

    <div class="mt-4">
        <h3>Tổng tiền: <%= request.getAttribute("orderTotal") %></h3>
    </div>

    <div class="mt-4">
        <a href="" class="btn btn-primary">Thanh toán</a>
    </div>
</div>

</body>
</html>




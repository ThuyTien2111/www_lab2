<%@ page import="vn.edu.iuh.fit.frontEndModel.EmployeeModel" %>
<%@ page import="vn.edu.iuh.fit.models.Employee" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm Nhân viên</title>
    <!-- Đường dẫn đến các tệp CSS và JS của Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        /* Custom CSS for narrower form */
        .container {
            max-width: 600px; /* Adjust this value to your desired width */
        }

        /* Optional: Adjust the label width */
        label {
            width: 100%;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Thêm Nhân viên</h1>
    <!-- Form nhập thông tin Nhân viên -->
    <form action="employeeControll?action=updateEmployee" method="post">
        <%
            Employee employee=(Employee) request.getAttribute("employee");
            LocalDateTime dob = employee.getDob();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String formattedDob = dob.format(formatter);
        %>
        <div class="form-group">
            <label for="empID">Mã nhân viên</label>
            <input type="text" class="form-control" id="empID" name="empID" value="<%= employee.getEmp_id() %>" readonly>
        </div>
        <div class="form-group">
            <label for="fullName">Họ và tên</label>
            <input type="text" class="form-control" id="fullName" name="fullName" value="<%= employee.getFullName() %>" required>
        </div>
        <div class="form-group">
            <label for="address">Địa chỉ</label>
            <input type="text" class="form-control" id="address" name="address" value="<%= employee.getAddress() %>" required>
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" value="<%= employee.getEmail() %>" required>
        </div>
        <div class="form-group">
            <label for="phone">Số điện thoại</label>
            <input type="tel" class="form-control" id="phone" name="phone" value="<%= employee.getPhone() %>" required>
        </div>
        <div class="form-group">
            <label for="dob">Ngày sinh</label>
            <input type="date" class="form-control" id="dob" name="dob" value="<%=formattedDob%>" required>
        </div>
        <div class="form-group">
            <label for="status">Trạng thái</label>
            <select class="form-control" id="status" name="status">
                <option value="0">STOPPED</option>
                <option value="1">ACTIVE</option>
                <option value="2">TERMINATED</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Xác nhận cập nhật</button>
    </form>
</div>
</body>
</html>

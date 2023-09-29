<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhân viên</title>
    <!-- Đường dẫn đến các tệp CSS và JS của Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="mt-5">Danh sách nhân viên</h1>

    <!-- Nút Thêm Nhân viên -->
    <a href="addEmployee.jsp" class="btn btn-primary mt-3 mb-3">Thêm Nhân viên</a>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Địa chỉ</th>
            <th>Email</th>
            <th>Số điện thoại</th>
            <th>Ngày sinh</th>
            <th>Trạng thái</th>
        </tr>
        </thead>
        <tbody>
        <%@ page import="vn.edu.iuh.fit.models.Employee" %>
        <%@ page import="java.util.List" %>
        <%@ page import="vn.edu.iuh.fit.service.EmployeeService" %>
        <%
            EmployeeService employeeService = new EmployeeService();
            List<Employee> employeeList = employeeService.getAllEmployees();

            for (Employee employee : employeeList) {
                String status="";
                if(employee.getStatus()==0) status="STOPED";
                else if(employee.getStatus()==1) status="ACTIVE";
                else status="TERMINATED";

        %>
        <tr>
            <td><%= employee.getEmp_id() %></td>
            <td><%= employee.getFullName() %></td>
            <td><%= employee.getAddress() %></td>
            <td><%= employee.getEmail() %></td>
            <td><%= employee.getPhone() %></td>
            <td><%= employee.getDob() %></td>
            <td><%=status %></td>
            <td>
                <a href="employeeControll?action=updateEmployee&empID=<%= employee.getEmp_id() %>" class="btn btn-primary btn-sm btn-block">Sửa</a>
                <a href="employeeControll?action=deleteEmployee&empID=<%= employee.getEmp_id() %>" class="btn btn-danger btn-sm btn-block">Xóa</a>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
</body>
</html>


</body>
</html>

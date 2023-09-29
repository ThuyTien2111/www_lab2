package vn.edu.iuh.fit.frontEndModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.service.EmployeeService;
import vn.edu.iuh.fit.service.OrderService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EmployeeModel {
    private final EmployeeService employeeService= new EmployeeService();
    public void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long empID= Long.parseLong(request.getParameter("empID"));
        String name=request.getParameter("fullName");
        String address=request.getParameter("address");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String dobString = request.getParameter("dob");

        // Định dạng chuỗi ngày sinh
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển chuỗi ngày sinh thành đối tượng LocalDateTime
        LocalDateTime dob = LocalDate.parse(dobString, formatter).atStartOfDay();
        int status = Integer.parseInt(request.getParameter("status"));

        employeeService.addEmployee(new Employee(empID, address, dob, email, name, phone, status));
        response.sendRedirect("employee.jsp");

    }
    public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long empID= Long.parseLong(request.getParameter("empID"));
        employeeService.deleteEmployee(empID);
        response.sendRedirect("employee.jsp");

    }
    public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long empID= Long.parseLong(request.getParameter("empID"));
        Employee employee= employeeService.getEmployeeById(empID);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("/editEmployee.jsp").forward(request, response);


    }
    public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long empID= Long.parseLong(request.getParameter("empID"));
        String name=request.getParameter("fullName");
        String address=request.getParameter("address");
        String email=request.getParameter("email");
        String phone=request.getParameter("phone");
        String dobString = request.getParameter("dob");
        // Định dạng chuỗi ngày sinh
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Chuyển chuỗi ngày sinh thành đối tượng LocalDateTime
        LocalDateTime dob = LocalDate.parse(dobString, formatter).atStartOfDay();
        int status = Integer.parseInt(request.getParameter("status"));

        employeeService.updateEmployee(new Employee(empID, address, dob, email, name, phone, status));
        response.sendRedirect("employee.jsp");
    }

    }

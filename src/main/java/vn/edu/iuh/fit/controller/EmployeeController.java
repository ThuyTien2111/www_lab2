package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.frontEndModel.EmployeeModel;
import vn.edu.iuh.fit.frontEndModel.OrderModel;

import java.io.IOException;

@WebServlet("/employeeControll")
public class EmployeeController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actObject= req.getParameter("action");
            if(actObject!=null){
                String action=actObject.toString();
                if(action.equals("addEmployee")){
                    EmployeeModel employeeModel= new EmployeeModel();
                    employeeModel.insertEmployee(req, resp);
                } else if (action.equals("updateEmployee")) {
                    EmployeeModel employeeModel= new EmployeeModel();
                    employeeModel.updateEmployee(req, resp);
                }

            } else{
                resp.sendRedirect("index.jsp");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Object actObject= req.getParameter("action");
            if(actObject!=null){
                String action=actObject.toString();
                if (action.equals("deleteEmployee")) {
                    EmployeeModel employeeModel= new EmployeeModel();
                    employeeModel.deleteEmployee(req, resp);
                } else if(action.equals("updateEmployee")){
                    EmployeeModel employeeModel= new EmployeeModel();
                    employeeModel.getEmployee(req, resp);
                }

            } else{
                resp.sendRedirect("index.jsp");
            }
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

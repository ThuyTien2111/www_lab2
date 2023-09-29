package vn.edu.iuh.fit.frontEndModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.service.OrderService;
import vn.edu.iuh.fit.service.ProductService;

import java.io.IOException;

public class ProductModel {
    private final OrderService productService= new OrderService();
    public void insertProductToOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        long productID= Long.parseLong(request.getParameter("productID"));
        double quantity= Double.parseDouble(request.getParameter("quantity"));
        long ordID= Long.parseLong(request.getParameter("orderCode"));
        long cusID= Long.parseLong(request.getParameter("customerCode"));
        long empID= Long.parseLong(request.getParameter("employeeCode"));
        String note=request.getParameter("note");






    }

}

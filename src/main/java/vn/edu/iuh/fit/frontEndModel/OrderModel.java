package vn.edu.iuh.fit.frontEndModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.service.OrderDetailService;
import vn.edu.iuh.fit.service.OrderService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class OrderModel {
    private final OrderService orderService= new OrderService();
    private final OrderDetailService orderDetailService=new OrderDetailService();
    public void insertProductToOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        long productID= Long.parseLong(request.getParameter("productID"));
        double quantity= Double.parseDouble(request.getParameter("quantity"));
        long ordID= Long.parseLong(request.getParameter("orderCode"));
        long cusID= Long.parseLong(request.getParameter("customerCode"));
        long empID= Long.parseLong(request.getParameter("employeeCode"));
        String note=request.getParameter("note");

        orderService.addOrder(new Order(ordID, LocalDateTime.now(), new Employee(empID), new Customer(cusID)), new OrderDetail(new Order(ordID), new Product(productID), note, quantity));

    }
    public void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        long ordID= Long.parseLong(request.getParameter("orderCode"));
 //       request.setAttribute("orderCode", ordID);
        List<OrderDetail> orderDetails =orderDetailService.getOrderDetailByOrderID(ordID);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    public void calcPriceOfCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        long ordID= Long.parseLong(request.getParameter("orderCode"));
        double total =orderDetailService.calcTotalPrice(ordID);
        request.setAttribute("orderTotal", total);
        List<OrderDetail> orderDetails =orderDetailService.getOrderDetailByOrderID(ordID);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("cart.jsp").forward(request, response);
    }


}

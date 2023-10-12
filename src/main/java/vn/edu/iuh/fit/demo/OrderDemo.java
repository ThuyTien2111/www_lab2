package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.OrderDAO;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.resource.OrderRequest;
import vn.edu.iuh.fit.service.OrderService;

import java.time.LocalDateTime;

public class OrderDemo {
    public static void main(String[] args) {
        OrderDAO orderDAO = new OrderDAO();
        OrderService orderService=new OrderService();
//        OrderRequest orderRequest= new OrderRequest(new Order(102, LocalDateTime.now(), new Employee(1), new Customer(2)),
//                new OrderDetail(new Order(102), new Product(2), "", 10));
//        System.out.println(orderService.addOrder(orderRequest.getOrder(), orderRequest.getOrderDetail()));
 /*       System.out.println(orderDAO.add(new Order(50, LocalDateTime.now(), new Employee(1), new Customer(2)),
                new OrderDetail(new Order(50), new Product(2), "", 2)));*/
       /* orderDAO.getOrderByDate().entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\nSo luong: " + entry.getValue());
        });*/
       /* orderDAO.getOrderByMonth().entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\nSo luong: " + entry.getValue());
        });*/
        orderDAO.getOrderByEmployeeForMonth().entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "\nSo luong: " + entry.getValue());
        });
    };

}

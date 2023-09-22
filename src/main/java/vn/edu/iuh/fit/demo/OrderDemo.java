package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.OrderDAO;
import vn.edu.iuh.fit.models.*;

import java.time.LocalDateTime;

public class OrdDetailDemo {
    public static void main(String[] args) {
        OrderDAO orderDAO= new OrderDAO();
        System.out.println(orderDAO.add(new Order(13, LocalDateTime.now(), new Employee(1), new Customer(2)),
                new OrderDetail(new Order(13), new Product(1), "", 3)));
    }
}

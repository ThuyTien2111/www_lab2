package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.OrderDAO;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderService {
    private OrderDAO orderDAO;

    public OrderService() {
        orderDAO = new OrderDAO();
    }
    public boolean addOrder(Order order, OrderDetail orderDetail){
        return  orderDAO.add(order, orderDetail);
    }
    public Map<LocalDateTime,Long> getOrderByDate(){
        return orderDAO.getOrderByDate();
    }
    public Map<String,Long> getOrderByMonth() {
        return orderDAO.getOrderByMonth();
    }
    public Map<String,Long> getOrderByEmployeeForMonth(){
        return orderDAO.getOrderByEmployeeForMonth();

    }


    }

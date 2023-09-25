package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.OrderDetailDAO;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.List;

public class OrderDetailService {
    private OrderDetailDAO orderDetailDAO;

    public OrderDetailService() {
        orderDetailDAO=new OrderDetailDAO();
    }
    public double calcTotalPrice(long orderID){
        return orderDetailDAO.calcTotalPrice(orderID);
    }
    public List<OrderDetail> getOrderDetailByOrderID(long orderID){
        return orderDetailDAO.getOrderDetailByOrderID(orderID);
    }

    }


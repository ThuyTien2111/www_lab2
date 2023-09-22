package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.OrderDetailDAO;

public class OrderDetailService {
    private OrderDetailDAO orderDetailDAO;

    public OrderDetailService() {
        orderDetailDAO=new OrderDetailDAO();
    }
    public double calcTotalPrice(long orderID){
        return orderDetailDAO.calcTotalPrice(orderID);
    }
    }


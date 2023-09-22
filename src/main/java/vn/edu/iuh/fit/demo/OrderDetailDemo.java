package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.OrderDetailDAO;

public class OrderDetailDemo {
    public static void main(String[] args) {
        OrderDetailDAO orderDetailDAO= new OrderDetailDAO();
        System.out.println(orderDetailDAO.calcTotalPrice(13));
    }
}

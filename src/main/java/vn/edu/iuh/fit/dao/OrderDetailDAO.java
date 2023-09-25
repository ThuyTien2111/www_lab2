package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO {
    private EntityManager em;
    public OrderDetailDAO() {
        em = Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public double calcTotalPrice(long orderID){
        double totalPrice=0;
        List<OrderDetail> list= new ArrayList<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT * \n" +
                    "FROM orderdetail\n" +
                    "WHERE OrderID=?";
            Query query = em.createNativeQuery(nativeQuery, OrderDetail.class);
            query.setParameter(1, orderID);
            list=query.getResultList();
            for (OrderDetail orderDetail:list) {
                totalPrice+=orderDetail.getPrice()*orderDetail.getQuantity();
            }

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return totalPrice;

    }
    public List<OrderDetail> getOrderDetailByOrderID(long orderID){
        List<OrderDetail> list= new ArrayList<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT * \n" +
                    "FROM orderdetail\n" +
                    "WHERE OrderID=?";
            Query query = em.createNativeQuery(nativeQuery, OrderDetail.class);
            query.setParameter(1, orderID);
            list=query.getResultList();

            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return list;

    }

}

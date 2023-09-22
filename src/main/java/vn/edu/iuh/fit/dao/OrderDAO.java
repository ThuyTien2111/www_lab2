package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.convert.OrderByDateDTO;
import vn.edu.iuh.fit.convert.OrderByEmployeeMonthDTO;
import vn.edu.iuh.fit.convert.OrderByMonthDTO;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO {
    private EntityManager em;
    public OrderDAO() {
        em= Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Order order, OrderDetail orderDetail)
    {
        ProductPrice pp = new ProductPrice();
        EntityTransaction tr=em.getTransaction();
        double price=0;
        tr.begin();
        try {
            //thêm order
            em.merge(order);
            //lấy thông tin giá của product để gán cho price của orderdetail
            String nativeQuery = "SELECT *\n" +
                    "FROM productprice \n" +
                    "WHERE productprice.ProductID =? \n" +
                    "AND productprice.PriceDate = (\n" +
                    "    SELECT MAX(productprice.PriceDate)\n" +
                    "    FROM productprice\n" +
                    "    WHERE productprice.ProductID =? \n" +
                    ");";
            Query query = em.createNativeQuery(nativeQuery, ProductPrice.class);
            query.setParameter(1, orderDetail.getProduct().getProduct_id());
            query.setParameter(2, orderDetail.getProduct().getProduct_id());
            pp= (ProductPrice) query.getSingleResult();
            price= (double) pp.getPrice();
            OrderDetail ord=new OrderDetail(orderDetail.getOrder(), orderDetail.getProduct(),
                    orderDetail.getNote(),price, orderDetail.getQuantity());
            em.persist(ord);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Map<LocalDateTime,Long> getOrderByDate(){
        Map<LocalDateTime,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT DATE(OrderDate) AS OrderDay, COUNT(*) AS TotalOrders\n" +
                    "FROM orders\n" +
                    "GROUP BY DATE(OrderDate)\n" +
                    "ORDER BY OrderDay;";
            List<OrderByDateDTO> list= em.createNativeQuery(nativeQuery, OrderByDateDTO.class).getResultList();
            for (OrderByDateDTO objects : list) {
                map.put(objects.getOrderDay(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
        e.printStackTrace();
        transaction.rollback();
        // TODO: handle exception
        }
		return map;

    }
    public Map<String,Long> getOrderByMonth(){
        Map<String,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT DATE_FORMAT(OrderDate, '%Y-%m') AS OrderMonth, COUNT(*) AS TotalOrders\n" +
                    "FROM orders\n" +
                    "GROUP BY OrderMonth\n" +
                    "ORDER BY OrderMonth";
            List<OrderByMonthDTO> list= em.createNativeQuery(nativeQuery, OrderByMonthDTO.class).getResultList();
            for (OrderByMonthDTO objects : list) {
                map.put(objects.getOrderMonth(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return map;

    }
    public Map<String,Long> getOrderByEmployeeForMonth(){
        Map<String,Long> map= new HashMap<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT employee.EmployeeID, employee.FullName, COUNT(orders.OrderID) AS TotalOrders\n" +
                    "FROM employee \n" +
                    "INNER JOIN orders ON employee.EmployeeID = orders.EmployeeID\n" +
                    "GROUP BY employee.EmployeeID, employee.FullName\n" +
                    "ORDER BY TotalOrders DESC;";
            List<OrderByEmployeeMonthDTO> list= em.createNativeQuery(nativeQuery, OrderByEmployeeMonthDTO.class).getResultList();
            for (OrderByEmployeeMonthDTO objects : list) {
                map.put(objects.getFullName(), objects.getTotalOrders());
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return map;

    }



}

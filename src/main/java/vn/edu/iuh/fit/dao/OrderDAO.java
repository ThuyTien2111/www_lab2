package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.*;

import java.util.ArrayList;
import java.util.List;

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
            em.persist(order);
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
}

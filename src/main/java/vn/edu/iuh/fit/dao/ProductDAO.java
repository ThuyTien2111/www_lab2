package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;

import java.util.List;

public class ProductDAO {
    private EntityManager em;
    public ProductDAO() {
        em= Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Product p)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            em.persist(p);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Product p )
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            em.merge(p);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Product get(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            return em.find(Product.class,id);
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Product> getAll()
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            return em.createQuery("select p from Product p", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public boolean detele(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();

        try {
            Product p=em.find(Product.class,id);
            p.setStatus(0);
            em.merge(p);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean activeProduct(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();

        try {
            Product p=em.find(Product.class,id);
            p.setStatus(1);
            em.merge(p);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
}

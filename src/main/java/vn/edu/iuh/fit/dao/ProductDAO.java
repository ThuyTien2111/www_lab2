package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.convert.OrderByDateDTO;
import vn.edu.iuh.fit.convert.ProductPricePath;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public List<ProductPricePath> getProductPricePaths(){
        List<ProductPricePath> list= new ArrayList<>();
        EntityTransaction transaction= em.getTransaction();
        transaction.begin();
        try {
            String nativeQuery= "SELECT\n" +
                    "    product.ProductID,\n" +
                    "\t product.Name ,\n" +
                    "    productprice.Price ,\n" +
                    "    productimage.Path \n" +
                    "FROM\n" +
                    "    product \n" +
                    "INNER JOIN\n" +
                    "    productprice AS productprice ON product.ProductID = productprice.ProductID\n" +
                    "INNER JOIN\n" +
                    "    productimage AS productimage ON product.ProductID = productimage.ProductID\n" +
                    "WHERE\n" +
                    "    productprice.PriceDate = (\n" +
                    "        SELECT\n" +
                    "            MAX(PriceDate)\n" +
                    "        FROM\n" +
                    "            productprice\n" +
                    "        WHERE\n" +
                    "            ProductID = product.ProductID\n" +
                    "    );";
            list= em.createNativeQuery(nativeQuery, ProductPricePath.class).getResultList();
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            // TODO: handle exception
        }
        return list;

    }


}

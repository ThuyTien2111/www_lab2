package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connection;
import vn.edu.iuh.fit.models.Employee;

import java.util.List;

public class EmployeeDAO {
    private EntityManager em;
    public EmployeeDAO() {
        em= Connection.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Employee emp)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            em.persist(emp);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Employee emp )
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
            em.merge(emp);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Employee get(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
        return em.find(Employee.class,id);
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Employee> getAll()
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();
        try {
        return em.createQuery("select c from Employee c", Employee.class).getResultList();
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
            Employee emp=em.find(Employee.class,id);
            emp.setStatus(0);
            em.merge(emp);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean activeEmp(long id)
    {
        EntityTransaction tr=em.getTransaction();
        tr.begin();

        try {
            Employee emp=em.find(Employee.class,id);
            emp.setStatus(1);
            em.merge(emp);;
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }

}

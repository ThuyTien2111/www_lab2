package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ProductDAO;

public class ProductDemo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        productDAO.getAll().forEach(p -> System.out.println(p.toString()));
    }
}

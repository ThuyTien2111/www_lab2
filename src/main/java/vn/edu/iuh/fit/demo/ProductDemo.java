package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ProductDAO;
import vn.edu.iuh.fit.service.ProductService;

public class ProductDemo {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        ProductService service= new ProductService();
      //  productDAO.getAll().forEach(p -> System.out.println(p.toString()));
        service.getProductPricePaths().forEach(p -> System.out.println(p.toString()));
    }
}

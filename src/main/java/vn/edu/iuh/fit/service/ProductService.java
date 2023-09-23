package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.convert.ProductPricePath;
import vn.edu.iuh.fit.dao.ProductDAO;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;

import java.util.List;

public class ProductService {
    private ProductDAO productDAO;

    public ProductService() {
        productDAO=new ProductDAO();
    }
    public boolean addProduct(Product product){
        if((product.getStatus()!=0)&&(product.getStatus()!=1)&&(product.getStatus()!=2)) return false;
        return productDAO.add(product);
    }
    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public Product getProductByID(long id) {
        return productDAO.get(id);
    }
    public boolean updateProduct(Product product) {
        if((product.getStatus()!=0)&&(product.getStatus()!=1)&&(product.getStatus()!=2)) return false;
        return productDAO.update(product);
    }
    public boolean deleteProduct(long id) {
        return productDAO.detele(id);
    }

    public boolean activateProduct(long id) {
        return productDAO.activeProduct(id);
    }

    public List<ProductPricePath> getProductPricePaths(){
        return productDAO.getProductPricePaths();
    }


    }

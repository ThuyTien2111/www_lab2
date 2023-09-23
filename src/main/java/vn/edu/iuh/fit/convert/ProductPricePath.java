package vn.edu.iuh.fit.convert;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductPricePath {
    @Id
    private long productID;
    private String name;
    private double price;
    private String path;

    public ProductPricePath() {
    }

    public ProductPricePath(long productID, String name, double price, String path) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.path = path;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "ProductPricePath{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", path='" + path + '\'' +
                '}';
    }
}

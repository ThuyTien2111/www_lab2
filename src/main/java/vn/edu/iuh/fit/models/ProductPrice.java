package vn.edu.iuh.fit.entities;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="ProductPrice")
public class ProductPrice {
    @Id
    @Column(name="PriceDate")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime price_date_time;
    @Column(name="Note",columnDefinition = "nvarchar(1000)")
    private String note;
    @Column(name="Price")
    private double price;
    @ManyToOne
    @JoinColumn(name="ProductID")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime price_date_time, String note, double price, Product product) {
        this.price_date_time = price_date_time;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price_date_time=" + price_date_time +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", product=" + product +
                '}';
    }
}

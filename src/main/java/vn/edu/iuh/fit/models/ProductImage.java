package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

@Entity
@Table(name="ProductImage")
public class ProductImage {
    @Id
    @Column(name="ImageID")
    private long image_id;
    @Column(name="Alternative",columnDefinition = "nvarchar(1000)")

    private String alternative;
    @Column(name="Alternative",columnDefinition = "nvarchar(500)")
    private String path;

    @ManyToOne
    @JoinColumn(name="ProductID")
    private Product product;

    public ProductImage() {
    }

    public ProductImage(long image_id, String alternative, String path, Product product) {
        this.image_id = image_id;
        this.alternative = alternative;
        this.path = path;
        this.product = product;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "image_id=" + image_id +
                ", alternative='" + alternative + '\'' +
                ", path='" + path + '\'' +
                ", product=" + product +
                '}';
    }
}

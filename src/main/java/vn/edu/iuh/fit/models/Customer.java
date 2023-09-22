package vn.edu.iuh.fit.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @Column(name="CustomerID")
    private long id;
    @Column(name="Address",columnDefinition = "nvarchar(500)")
    private String address;
    @Column(name="Email",columnDefinition = "nvarchar(500)")
    private String email;
    @Column(name="FullName",columnDefinition = "nvarchar(100)")
    private String name;
    @Column(name="Phone",columnDefinition = "nvarchar(10)")
    private String phone;

    public Customer() {
    }

    public Customer(long id) {
        this.id = id;
    }

    public Customer(long id, String address, String email, String name, String phone) {
        this.id = id;
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

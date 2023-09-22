package vn.edu.iuh.fit.models;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name="Employee")
public class Employee {
    @Id
    @Column(name="EmployeeID")
    private long emp_id;
    @Column(name="Address",columnDefinition = "nvarchar(500)")
    private String address;
    @Column(name="DateOfBirth")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDateTime dob;
    @Column(name="Email",columnDefinition = "nvarchar(500)")
    private String email;
    @Column(name="FullName",columnDefinition = "nvarchar(100)")
    private String fullName;
    @Column(name="Phone",columnDefinition = "nvarchar(10)")
    private String phone;
    @Column(name="Status")
    private int status;

    public Employee() {
    }

    public Employee(long emp_id) {
        this.emp_id = emp_id;
    }

    public Employee(long emp_id, String address, LocalDateTime dob, String email, String fullName, String phone, int status) {
        this.emp_id = emp_id;
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + emp_id +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}

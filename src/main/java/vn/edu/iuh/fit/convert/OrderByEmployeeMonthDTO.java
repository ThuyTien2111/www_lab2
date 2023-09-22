package vn.edu.iuh.fit.convert;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderByEmployeeMonthDTO {
    @Id
    private String fullName;
    private long totalOrders;

    public OrderByEmployeeMonthDTO() {
    }

    public OrderByEmployeeMonthDTO(String fullName, long totalOrders) {
        this.fullName = fullName;
        this.totalOrders = totalOrders;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "OrderByEmployeeMonthDTO{" +
                "fullName='" + fullName + '\'' +
                ", totalOrders=" + totalOrders +
                '}';
    }
}

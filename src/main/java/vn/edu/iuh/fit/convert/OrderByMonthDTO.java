package vn.edu.iuh.fit.convert;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderByMonthDTO {
    @Id
    private String orderMonth;
    private long totalOrders;

    public OrderByMonthDTO() {
    }

    public OrderByMonthDTO(String orderMonth, long totalOrders) {
        this.orderMonth = orderMonth;
        this.totalOrders = totalOrders;
    }

    public String getOrderMonth() {
        return orderMonth;
    }

    public void setOrderMonth(String orderMonth) {
        this.orderMonth = orderMonth;
    }

    public long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(long totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "OrderByMonthDTO{" +
                "orderMonth='" + orderMonth + '\'' +
                ", totalOrders=" + totalOrders +
                '}';
    }
}

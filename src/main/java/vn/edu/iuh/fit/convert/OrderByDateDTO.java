package vn.edu.iuh.fit.convert;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
public class OrderByDateDTO {
    @Id
    private LocalDateTime orderDay;
    private Long totalOrders;

        // Getter và Setter


    public OrderByDateDTO() {
    }

    public OrderByDateDTO(LocalDateTime orderDay, Long totalOrders) {
        this.orderDay = orderDay;
        this.totalOrders = totalOrders;
    }

    public LocalDateTime getOrderDay() {
        return orderDay;
    }

    public void setOrderDay(LocalDateTime orderDay) {
        this.orderDay = orderDay;
    }

    public Long getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    @Override
    public String toString() {
        return "OrderByDateDTO{" +
                "orderDay=" + orderDay +
                ", totalOrders=" + totalOrders +
                '}';
    }
}

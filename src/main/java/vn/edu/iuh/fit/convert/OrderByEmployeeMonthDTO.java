package vn.edu.iuh.fit.convert;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@SqlResultSetMapping(
        name = "OrderByEmployeeMonthMapping",
        classes = {
                @ConstructorResult(
                        targetClass = OrderByEmployeeMonthDTO.class,
                        columns = {
                                @ColumnResult(name = "FullName", type = String.class),
                                @ColumnResult(name = "TotalOrders", type = Long.class)
                        }
                )
        }
)
public class OrderByEmployeeMonthDTO {
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

package vn.edu.iuh.fit.convert;

import jakarta.persistence.*;

@SqlResultSetMapping(
        name = "OrderByMonthMapping",
        classes = {
                @ConstructorResult(
                        targetClass = OrderByMonthDTO.class,
                        columns = {
                                @ColumnResult(name = "OrderMonth", type = String.class),
                                @ColumnResult(name = "TotalOrders", type = Long.class)
                        }
                )
        }
)
public class OrderByMonthDTO {
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

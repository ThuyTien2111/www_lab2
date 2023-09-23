package vn.edu.iuh.fit.resource;

import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;

public class OrderRequest {
    private Order order;
    private OrderDetail orderDetail;

    // Getter và Setter cho order và orderDetail
    // ...


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public String toString() {
        return "OrderRequest{" +
                "order=" + order +
                ", orderDetail=" + orderDetail +
                '}';
    }

    // Constructors
    public OrderRequest() {
    }

    public OrderRequest(Order order, OrderDetail orderDetail) {
        this.order = order;
        this.orderDetail = orderDetail;
    }
}


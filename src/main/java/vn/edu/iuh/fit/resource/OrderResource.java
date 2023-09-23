package vn.edu.iuh.fit.resource;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Order;
import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.service.OrderService;

import java.time.LocalDateTime;
import java.util.Map;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderResource {
    private OrderService orderService;

    public OrderResource() {
        this.orderService = new OrderService();
    }

    /*@POST
    public Response addOrder(Order order, OrderDetail orderDetail) {
        boolean added = orderService.addOrder(order, orderDetail);
        if (added) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }*/
    @POST
    @Path("/add")
    @Produces("application/json")
    public Response addOrder(OrderRequest orderRequest) {
        boolean added = orderService.addOrder(orderRequest.getOrder(), orderRequest.getOrderDetail());
        if (added) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/by-date")
    public Map<LocalDateTime, Long> getOrderByDate() {
        return orderService.getOrderByDate();
    }

    @GET
    @Path("/by-month")
    public Map<String, Long> getOrderByMonth() {
        return orderService.getOrderByMonth();
    }

    @GET
    @Path("/by-employee-for-month")
    public Map<String, Long> getOrderByEmployeeForMonth() {
        return orderService.getOrderByEmployeeForMonth();
    }
}

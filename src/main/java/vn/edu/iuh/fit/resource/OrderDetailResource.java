package vn.edu.iuh.fit.resource;

import vn.edu.iuh.fit.models.OrderDetail;
import vn.edu.iuh.fit.service.OrderDetailService;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/orders")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class OrderDetailResource {
    private OrderDetailService orderDetailService;

    public OrderDetailResource() {
        orderDetailService = new OrderDetailService();
    }

    @GET
    @Path("/{orderId}/totalPrice")
    public Response calculateTotalPrice(@PathParam("orderId") long orderId) {
        double totalPrice = orderDetailService.calcTotalPrice(orderId);

        if (totalPrice >= 0) {
            return Response.ok(totalPrice).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Order with ID " + orderId + " not found")
                    .build();
        }
    }
    @GET
    @Path("/{orderId}/detail")
    public List<OrderDetail> getOrderDetailByOrderID(@PathParam("orderId") long orderId) {
        return orderDetailService.getOrderDetailByOrderID(orderId);
    }
}

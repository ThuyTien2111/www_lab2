package vn.edu.iuh.fit.resource;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.convert.ProductPricePath;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.service.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    private ProductService productService;

    public ProductResource() {
        productService=new ProductService();
    }

    @GET
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GET
    @Path("/{productId}")
    public Response getProductById(@PathParam("productId") long productId) {
        Product product = productService.getProductByID(productId);
        if (product != null) {
            return Response.ok(product).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @GET
    @Path("/show")
    public List<ProductPricePath> getAllProductAndPricePath() {
            return productService.getProductPricePaths();
    }

    @POST
    public Response addProduct(Product product) {
        boolean added = productService.addProduct(product);
        if (added) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{productId}")
    public Response updateProduct(@PathParam("productId") long productId, Product updatedProduct) {
        if (productService.updateProduct(updatedProduct)) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteProduct(@PathParam("productId") long productId) {
        boolean deleted = productService.deleteProduct(productId);
        if (deleted) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Path("/{productId}/activate")
    public Response activateProduct(@PathParam("productId") long productId) {
        boolean activated = productService.activateProduct(productId);
        if (activated) {
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}

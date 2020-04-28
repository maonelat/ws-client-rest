package org.acme.soap.resource;

import org.acme.soap.service.ProductService;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.tempuri.Product;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService productService;

    @GET
    @Path("/{productID}")
    @Counted(name = "getProductChecks", absolute = true, description = "How many primality checks have been performed.")
    @Timed(name = "getProduct", absolute = true, description = "A measure of how long it takes to perform the task.", unit = MetricUnits.MILLISECONDS)
    public Response getProduct(@PathParam("productID")int productID){
        return Response.ok(productService.getProduct(productID)).build();
    }

    @POST
    @Path("/{productID}")
    public Response postProduct(@PathParam("productID")int productID,Product product){
        return Response.ok(productService.updateProduct(productID,product)).build();
    }

    @PUT
    public Response putProduct(Product product){
        return Response.ok(productService.createProduct(product)).build();
    }

    @DELETE
    @Path("/{productID}")
    @Timed(name = "deleteProduct", absolute = true, description = "A measure of how long it takes to perform the task.", unit = MetricUnits.MILLISECONDS)
    public Response deleteProduct(@PathParam("productID")int productID){
        return Response.ok(productService.deleteProduct(productID)).build();
    }
}

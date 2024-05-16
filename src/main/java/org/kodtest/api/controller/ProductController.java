package org.kodtest.api.controller;

import org.kodtest.api.model.Product;
import org.kodtest.api.service.ProductService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/api/products")
public class ProductController {

	private final ProductService productService;

	@Inject
	public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProductById(@PathParam("id") int id) {
        return productService.getProductById(id);
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
    
    @GET
    @Path("/available")
    @Produces(MediaType.TEXT_PLAIN)
    public String available() {
       return "yes";
    }
}

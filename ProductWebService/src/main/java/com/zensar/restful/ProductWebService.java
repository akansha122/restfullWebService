package com.zensar.restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.zensar.entities.Product;
import com.zensar.services.ProductService;
import com.zensar.services.ProductServiceImpl;

/**
 * @author Akansha Shah
 * @Creation_date 4th Oct 2019 10.23AM
 * @Modification_date 4th Oct 2019 11.38AM
 * @version 1.0
 * @Copyright Zensar Technologies. All rights reserved
 * @description It is an service interface used in business layer.
 */
@Path("/products")
public class ProductWebService {

	private ProductService productService;

	public ProductWebService() {
		productService = new ProductServiceImpl();
	}

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getAllProducts() {
		return productService.findAllProducts();
	}

	@GET
	@Path("/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Product getProduct(@PathParam("id") int productId) {
		return productService.findProductById(productId);
	}

	@GET
	@Path("/count")
	@Produces("text/html")
	public Response getProductCount() {
		long count = productService.getProductCount();
		return Response.status(200).entity("<h1>" + "No of products" + " " + count + "</h1>").build();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces("text/html")
	public Response add(Product product) {
		productService.addProduct(product);
		return Response.status(200).entity("product" + product.getProductId() + "is added succesfully").build();
	}

	@PUT
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces("text/html")
	public Response update(Product product) {
		Product dbProduct = productService.findProductById(product.getProductId());
		if (dbProduct != null) {
			dbProduct.setName(product.getName());
			dbProduct.setBrand(product.getBrand());
			dbProduct.setPrice(product.getPrice());
			
			productService.updateProduct(dbProduct);
			return Response.status(200).entity("product" + dbProduct + "updated successfully").build();
		} else {
			return Response.status(200).entity("Sorry! product not found").build();
		}
	}

	@DELETE
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces("text/html")
	public Response remove(Product product) {
		Product dbProduct = productService.findProductById(product.getProductId());
		if (dbProduct != null) {
			productService.removeProduct(dbProduct);
			return Response.status(200).entity("Deleted successfully").build();
		} else {
			return Response.status(200).entity("Sorry! product not deletd").build();
		}
	}
    @POST
    @Path("/pricerange")
    @Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public List<Product> getByPriceRange(@FormParam("min") float minPrice, @FormParam("max") float maxPrice) {
		return productService.findProductsByPriceRange(minPrice, maxPrice);
	}

}

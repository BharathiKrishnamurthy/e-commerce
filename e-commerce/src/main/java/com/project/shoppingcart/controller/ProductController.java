package com.project.shoppingcart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.project.shoppingcart.exception.ProductNotFoundException;
import com.project.shoppingcart.model.Product;
import com.project.shoppingcart.service.product.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(path="/test")
	public String test() {
		System.out.println("Working");
		return "Working";
	}
	
	/**
	 * getAllProducts is used to get all the products from DB
	 */
	@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	/**
	 * getProduct is used to get the specific order from DB based on product id
	 */
	@GetMapping(path="/products/{id}")
	public Optional<Product> getProduct(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getProduct(id);
		if(!product.isPresent()) {
			throw new ProductNotFoundException("Product: " + id + " is Not Found !!");
		}
		return product;
	}

}

package com.project.shoppingcart.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.shoppingcart.model.Product;

@Service
public interface ProductService {

	List<Product> getAllProducts();
	
	Product save(Product product);

	Optional<Product> getProduct(Long id);

}

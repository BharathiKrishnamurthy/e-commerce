package com.project.shoppingcart.dao.product;

import java.util.List;
import java.util.Optional;

import com.project.shoppingcart.model.Product;

public interface ProductDao {

	List<Product> getAllProducts();

	Product save(Product product);

	Optional<Product> getProduct(Long id);

}

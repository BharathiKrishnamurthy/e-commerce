package com.project.shoppingcart.dao.product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.shoppingcart.model.Product;
import com.project.shoppingcart.repository.ProductRepository;

@Component
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList(new LinkedHashSet(productRepository.findAll()));
		Collections.sort(products, (o1,o2) -> o1.getPrice().compareTo(o2.getPrice()));
		return products;
	}

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}

}

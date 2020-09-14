package com.project.shoppingcart.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.shoppingcart.dao.product.ProductDao;
import com.project.shoppingcart.model.Product;

@Component
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getAllProducts() {
		return productDao.getAllProducts();
	}

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public Optional<Product> getProduct(Long id) {
		return productDao.getProduct(id);
	}
	
}

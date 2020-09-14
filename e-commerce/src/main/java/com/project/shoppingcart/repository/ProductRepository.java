package com.project.shoppingcart.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shoppingcart.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findAll(Sort sort);

}

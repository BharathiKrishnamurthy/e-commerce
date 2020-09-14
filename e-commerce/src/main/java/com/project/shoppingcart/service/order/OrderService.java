package com.project.shoppingcart.service.order;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.shoppingcart.model.Order;

@Service
public interface OrderService {

	List<Order> getAllOrders();

	Optional<Order> getProduct(Long id);
	
	Order create(Order order);
	
	void update(Order order);

	void delete(Long id);

	Order checkout(Order order);

}

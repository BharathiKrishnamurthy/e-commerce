package com.project.shoppingcart.dao.order;

import java.util.List;
import java.util.Optional;

import com.project.shoppingcart.model.Order;

public interface OrderDao {

	List<Order> getAllOrders();

	Optional<Order> getOrder(Long id);

	Order create(Order order);

	void update(Order order);

	void delete(Long id);

	Order checkOut(Order order);

}

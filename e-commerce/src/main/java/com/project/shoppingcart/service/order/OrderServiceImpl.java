package com.project.shoppingcart.service.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.shoppingcart.dao.order.OrderDao;
import com.project.shoppingcart.model.Order;

@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;

	@Override
	public List<Order> getAllOrders() {
		return orderDao.getAllOrders();
	}

	@Override
	public Optional<Order> getProduct(Long id) {
		return orderDao.getOrder(id);
	}
	
	@Override
    public Order create(Order order) {
        return orderDao.create(order);
    }
 
    @Override
    public void update(Order order) {
    	orderDao.update(order);
    }

	@Override
	public void delete(Long id) {
		orderDao.delete(id);
	}

	@Override
	public Order checkout(Order order) {
		return orderDao.checkOut(order);
	}

}

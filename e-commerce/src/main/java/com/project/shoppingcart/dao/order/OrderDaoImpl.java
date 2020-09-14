package com.project.shoppingcart.dao.order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.shoppingcart.model.Order;
import com.project.shoppingcart.model.OrderProduct;
import com.project.shoppingcart.model.OrderProductPK;
import com.project.shoppingcart.model.Product;
import com.project.shoppingcart.repository.OrderRepository;

@Component
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	OrderRepository orderRepository;

	
	/**
	 * getAllOrdersis used to get all the order details.
	 * If is is empty, then will create a default one.
	 */
	@Override
	public List<Order> getAllOrders() {
		Product produtDetails = new Product();
		produtDetails.setProduct_id(0L);
		produtDetails.setPrice(0.00);
		produtDetails.setProductname("DEFAULT");
		
		Order orderDetils = new Order();
		orderDetils.setOrder_id(0L);
		orderDetils.setDateCreated(LocalDate.now());
		orderDetils.setStatus("NEW");
		
		OrderProductPK orderProductPK = new OrderProductPK();
		orderProductPK.setOrder(orderDetils);
		orderProductPK.setProduct(produtDetails);
		
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.setPk(orderProductPK);
		orderProduct.setQuantity(0);
		
		List<OrderProduct> orderProducts = new ArrayList<>();
		orderProducts.add(orderProduct);
		
		orderDetils.setOrderProducts(orderProducts);
		
		List<Order> order = orderRepository.findAll();
		if(order.isEmpty()) {
			order.add(orderDetils);
		}
		return order;
	}

	@Override
	public Optional<Order> getOrder(Long id) {
		return orderRepository.findById(id);
	}
	
	@Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());
        order.setStatus("NEW");
        return orderRepository.save(order);
    }
 
    @Override
    public void update(Order order) {
        orderRepository.save(order);
    }

	@Override
	public void delete(Long id) {
		Order order = orderRepository.getOne(id);
		orderRepository.delete(order);
	}

	@Override
	public Order checkOut(Order order) {
		return orderRepository.save(order);
	}

}

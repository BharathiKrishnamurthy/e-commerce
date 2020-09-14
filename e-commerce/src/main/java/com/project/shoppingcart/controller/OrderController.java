package com.project.shoppingcart.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.project.shoppingcart.exception.ProductNotFoundException;
import com.project.shoppingcart.model.Order;
import com.project.shoppingcart.model.OrderProduct;
import com.project.shoppingcart.service.order.OrderService;

/**
 * @author Bharathi
 *
 */
/**
 * @author Bharathi
 *
 */
@RestController
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(path="/check")
	public String test() {
		System.out.println("Working");
		return "Order Working";
	}
	
	/**
	 * getAllOrders is used to get all the Orders form Shopping cart using /cart
	 */
	@GetMapping(path="/cart", produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE })
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}
	
	/**
	 * getProduct is used to get the specific order by ID form shooping cart using cart/cart_id
	 */
	@GetMapping(path="/cart/{cart_id}")
	public Optional<Order> getProduct(@PathVariable("cart_id") Long id) {
		Optional<Order> order = orderService.getProduct(id);
		if(!order.isPresent()) {
			throw new ProductNotFoundException("Order: " + id + " is Not Found !! Empty Cart!!");
		}
		return order;
	}
	
	/**
	 * addOrderDetails is used to create a new Order based on product
	 */
	@PostMapping(path="/cart", consumes= {"application/json"})
	public ResponseEntity<Object> addOrderDetails(@RequestBody Order order) {
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.getPk().getOrder();
		orderProduct.getPk().getProduct();
		orderProduct.getQuantity();
		orderProduct.getTotalPrice();
		
		List<OrderProduct> orderProducts = new ArrayList<>();
		orderProducts.add(orderProduct);
		order.setOrderProducts(orderProducts);
		
		Order orderDetails = orderService.create(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/order_id}").buildAndExpand(orderDetails.getOrder_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	/**
	 * updateOrderDetails is used to update the specific order in shopping cart
	 */
	@PutMapping(path="/cart/{cart_id}")
	public ResponseEntity<Object> updateOrderDetails(@RequestBody Order order) {
		order.setStatus("UPDATED");
		orderService.update(order);
		return ResponseEntity.created(URI.create("")).build();
	}
	
	/**
	 * deleteOrderDetails is used to delete the specific order in shopping cart
	 */
	@DeleteMapping(path="/cart/{cart_id}")
	public ResponseEntity<Object> deleteOrderDetails(@PathVariable("cart_id") Long id) {
		orderService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	/**
	 * checkOut method is used to Ordered the specific order
	 */
	@PostMapping(path="/cart/{cart_id}/checkout")
	public ResponseEntity<Object> checkOut(Order order) {
		OrderProduct orderProduct = new OrderProduct();
		orderProduct.getPk().getOrder();
		orderProduct.getPk().getProduct();
		orderProduct.getQuantity();
		orderProduct.getTotalPrice();
		
		List<OrderProduct> orderProducts = new ArrayList<>();
		orderProducts.add(orderProduct);
		order.setOrderProducts(orderProducts);
		
		Order orderDetails = orderService.checkout(order);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("{/order_id}").buildAndExpand(orderDetails.getOrder_id()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	
}

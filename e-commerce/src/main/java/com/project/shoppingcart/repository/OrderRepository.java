package com.project.shoppingcart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.shoppingcart.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

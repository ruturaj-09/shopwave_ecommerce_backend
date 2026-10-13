package com.shopwave.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}

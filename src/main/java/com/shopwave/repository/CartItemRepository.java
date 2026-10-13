package com.shopwave.repository;

import com.shopwave.model.Cart;
import com.shopwave.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import com.shopwave.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    CartItem findByCartAndProductAndSize(Cart cart, Product product, String size);


}

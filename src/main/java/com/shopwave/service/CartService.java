package com.shopwave.service;

import com.shopwave.exception.ProductException;
import com.shopwave.model.Cart;
import com.shopwave.model.CartItem;
import com.shopwave.model.Product;
import com.shopwave.model.User;

public interface CartService {
	
	public CartItem addCartItem(User user,
								Product product,
								String size,
								int quantity) throws ProductException;
	
	public Cart findUserCart(User user);

}

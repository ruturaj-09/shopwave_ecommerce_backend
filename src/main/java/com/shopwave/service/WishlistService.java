package com.shopwave.service;


import com.shopwave.exception.WishlistNotFoundException;
import com.shopwave.model.Product;
import com.shopwave.model.User;
import com.shopwave.model.Wishlist;

public interface WishlistService {

    Wishlist createWishlist(User user);

    Wishlist getWishlistByUserId(User user);

    Wishlist addProductToWishlist(User user, Product product) throws WishlistNotFoundException;

}


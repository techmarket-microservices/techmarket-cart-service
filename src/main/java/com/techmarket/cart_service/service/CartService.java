package com.techmarket.cart_service.service;

import com.techmarket.cart_service.model.CartItem;

import java.util.List;

public interface CartService {
    List<CartItem> addProduct(String userId, String productId, int quantity);
    List<CartItem> getCart(String userId);
    void clearCart(String userId);
}

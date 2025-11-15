package com.techmarket.cart_service.service.imp;

import com.techmarket.cart_service.model.CartItem;
import com.techmarket.cart_service.repository.CartItemRepository;
import com.techmarket.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService {
    private final CartItemRepository cartItemRepository;

    private static final String CART_PREFIX = "cart:user";

    @Override
    @CachePut(value = CART_PREFIX, key = "#userId")
    public List<CartItem> addProduct(String userId, String productId, int quantity) {
        CartItem cartItem = cartItemRepository.findByUserIdAndProductId(userId, productId)
                .orElse(new CartItem(null, userId, productId, 0));
        cartItem.setQuantity(cartItem.getQuantity() + quantity);
        cartItemRepository.save(cartItem);
        return cartItemRepository.findByUserId(userId);
    }

    @Override
    @Cacheable(value = CART_PREFIX, key = "#userId")
    public List<CartItem> getCart(String userId) {
        return cartItemRepository.findByUserId(userId);
    }

    @Override
    @CacheEvict(value = CART_PREFIX, key = "#userId")
    public void clearCart(String userId) {
        cartItemRepository.deleteByUserId(userId);
    }
}

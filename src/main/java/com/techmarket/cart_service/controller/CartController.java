package com.techmarket.cart_service.controller;

import com.techmarket.cart_service.constants.ApiPaths;
import com.techmarket.cart_service.dto.request.AddToCartRequest;
import com.techmarket.cart_service.dto.response.ApiResponse;
import com.techmarket.cart_service.model.CartItem;
import com.techmarket.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.BASE_URL)
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddToCartRequest request){
        cartService.addProduct(request.getUserId(), request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(new ApiResponse("Product added to cart", true));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<CartItem>> getCart(@PathVariable String userId){
         return ResponseEntity.ok(cartService.getCart(userId));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> clearCart(@PathVariable String userId){
        cartService.clearCart(userId);
        return ResponseEntity.ok(new ApiResponse("Cart cleared", true));
    }
}

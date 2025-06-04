package com.example.demo.shopping_cart_kata;

import java.math.BigDecimal;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        this.quantity = 1;
    }

    public BigDecimal price() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}

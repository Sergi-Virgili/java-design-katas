package com.example.demo.shopping_cart_kata;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    @Test
    void shouldReturnTotalPriceForOneProduct() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Keyboard", BigDecimal.valueOf(50)));

        assertEquals(BigDecimal.valueOf(50), cart.totalPrice());
    }

    @Test
    void shouldReturnA() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Product("Keyboard", BigDecimal.valueOf(50)));
        cart.add(new Product("Keyboard", BigDecimal.valueOf(40)));

        assertEquals(BigDecimal.valueOf(90), cart.totalPrice());
    }

    @Test
    void shouldApplyPercentageDiscountToCartTotal() {
        ShoppingCart cart = new ShoppingCart();

        Product product = new Product("name", BigDecimal.valueOf(50));
        cart.add(product);

        BigDecimal discountedTotal = cart.totalWithDiscount(new PercentageDiscount(10));

        assertEquals(new BigDecimal("45.00"), discountedTotal);
    }

}
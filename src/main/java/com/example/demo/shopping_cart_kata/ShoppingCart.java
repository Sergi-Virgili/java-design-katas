package com.example.demo.shopping_cart_kata;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CartItem> items = new ArrayList<>();

    public void add(Product product) {
        items.add(new CartItem(product));
    }

    public BigDecimal totalPrice() {
        return items.stream().map((CartItem cardItem) -> cardItem.price())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal totalWithDiscount(DiscountPolicy discountPolicy) {
        return discountPolicy.apply(totalPrice());
    }
}

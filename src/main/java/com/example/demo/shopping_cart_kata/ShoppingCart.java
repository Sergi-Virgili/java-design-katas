package com.example.demo.shopping_cart_kata;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final List<CardItem> items = new ArrayList<>();

    public void add(Product product) {
        items.add(new CardItem(product));
    }

    public BigDecimal totalPrice() {
        return items.stream().map((CardItem cardItem) -> cardItem.price())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    public BigDecimal totalWithDiscount(int percentage) {
        return this.totalPrice().subtract(this.totalPrice()
                .multiply(BigDecimal.valueOf(percentage))
                .divide(BigDecimal.valueOf(100), 2, BigDecimal.ROUND_HALF_UP));
    }
}

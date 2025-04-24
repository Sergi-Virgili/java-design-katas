package com.example.demo.shopping_cart_kata;

import java.math.BigDecimal;

public interface DiscountPolicy {
    BigDecimal apply(BigDecimal total);

}

package com.example.demo.shopping_cart_kata;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageDiscount implements DiscountPolicy{
    private final BigDecimal percentage;

    public PercentageDiscount(int percentage) {
        this.percentage = BigDecimal.valueOf(percentage);
    }

    @Override
    public BigDecimal apply(BigDecimal total) {
        BigDecimal discount = total
                .multiply(percentage)
                .divide(BigDecimal.valueOf(100), 2, RoundingMode.HALF_UP);
        return total.subtract(discount);
    }
}

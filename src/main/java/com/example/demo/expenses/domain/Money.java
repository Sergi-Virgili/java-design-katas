package com.example.demo.expenses.domain;

import com.example.demo.expenses.domain.exception.InvalidMoneyValueException;
import com.example.demo.expenses.domain.exception.MoneyOperationException;

import java.math.BigDecimal;
import java.util.Objects;

public record Money(
        BigDecimal value
) {
    public Money {
        if (value == null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new InvalidMoneyValueException(value);
        }
    }

    public Money add(Money other) {
        if (other == null) {
            throw new MoneyOperationException("Cannot add null Money");
        }
        return new Money(this.value.add(other.value));
    }

    public boolean isGreaterThanOrEqual(Money other) {
        Objects.requireNonNull(other, "Other Money cannot be null");
        return this.value.compareTo(other.value) >= 0;
    }
}

package com.example.demo.expenses.domain.exception;

import java.math.BigDecimal;

public class InvalidMoneyValueException extends DomainException {
    public InvalidMoneyValueException(BigDecimal value) {
        super("Invalid money value: " + value + ". Money value cannot be negative or null.");
    }
}

package com.example.demo.expenses.domain.exception;

public class MoneyOperationException extends RuntimeException {
    public MoneyOperationException(String cannotAddNullMoney) {
    }
}

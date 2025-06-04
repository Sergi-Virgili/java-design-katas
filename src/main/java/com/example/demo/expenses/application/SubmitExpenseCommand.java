package com.example.demo.expenses.application;

import java.math.BigDecimal;

public record SubmitExpenseCommand(String employeeId, String description,
                                   BigDecimal amount, String type,
                                   String companyId) {
}


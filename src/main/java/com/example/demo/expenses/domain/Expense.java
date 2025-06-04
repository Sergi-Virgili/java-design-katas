package com.example.demo.expenses.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Expense {

    private final EmployeeId employeeId;
    private final ExpenseDescription description;
    private final Money amount;
    private final ExpenseType type;
    private final ExpenseStatus status;

    public Expense(EmployeeId employeeId, ExpenseDescription description, Money amount, ExpenseType type, ExpenseStatus status) {
        this.employeeId = employeeId;
        this.description = description;
        this.amount = amount;
        this.type = type;
        this.status = status;
    }

    public static Expense create(EmployeeId employeeId, ExpenseDescription description, Money amount, ExpenseType type, ApprovalPolicy policy) {

        boolean requiresApproval = amount.isGreaterThanOrEqual(new Money(new BigDecimal("100.00")));

        ExpenseStatus status = requiresApproval
                ? new ExpenseStatus("REQUIRES_APPROVAL")
                : new ExpenseStatus("APPROVED");

        return new Expense(employeeId, description, amount, type, status);
    }

    public ExpenseStatus status() {
        return status;
    }

    public Money amount() {
        return amount;
    }

    public ExpenseDescription description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Expense expense)) return false;
        return Objects.equals(employeeId, expense.employeeId) && Objects.equals(description, expense.description) && Objects.equals(amount, expense.amount) && Objects.equals(type, expense.type) && Objects.equals(status, expense.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, description, amount, type, status);
    }

    @Override
    public String toString() {
        return "Expense{" +
                "employeeId=" + employeeId +
                ", description=" + description +
                ", amount=" + amount +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}

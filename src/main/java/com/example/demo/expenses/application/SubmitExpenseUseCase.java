package com.example.demo.expenses.application;

import com.example.demo.expenses.domain.*;

public class SubmitExpenseUseCase {
    private final ExpenseRequestRepository expenseRequestRepository;
    private final ApprovalPolicyProvider policyProvider;

    public SubmitExpenseUseCase(ExpenseRequestRepository expenseRequestRepository, ApprovalPolicyProvider policyProvider) {
        this.expenseRequestRepository = expenseRequestRepository;
        this.policyProvider = policyProvider;
    }

    public void execute(SubmitExpenseCommand command) {
        EmployeeId employeeId = new EmployeeId(command.employeeId());
        Money amount = new Money(command.amount());
        ExpenseDescription description = new ExpenseDescription(command.description());
        ExpenseType type = new ExpenseType(command.type());

        ApprovalPolicy policy = policyProvider.forCompany(command.companyId());

        Expense expense = Expense.create(employeeId, description, amount, type, policy);

        expenseRequestRepository.save(expense);
    }
}

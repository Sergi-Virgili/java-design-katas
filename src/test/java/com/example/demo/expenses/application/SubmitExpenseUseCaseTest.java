package com.example.demo.expenses.application;

import com.example.demo.expenses.domain.ExpenseRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SubmitExpenseUseCaseTest {

    @Mock
    ExpenseRequestRepository repository;

    @Mock
    ApprovalPolicyProvider policyProvider;

    SubmitExpenseUseCase useCase;

    @BeforeEach
    void setUp() {
        useCase = new SubmitExpenseUseCase(repository, policyProvider);
    }

    @Test
    void shouldAutomaticallyApproveExpenseWhenBelowThreshold() {
        SubmitExpenseCommand command = new SubmitExpenseCommand(
                "emp-123",
                "Taxi ride from airport",
                new BigDecimal("99.99"),
                "TRANSPORT",
                "company-112f"
        );

        useCase.execute(command);

        verify(repository).save(argThat(expense ->
                expense.status().value().equals("APPROVED") &&
                        expense.amount().value().equals(new BigDecimal("99.99")) &&
                        expense.description().value().equals("Taxi ride from airport")
        ));
    }
}
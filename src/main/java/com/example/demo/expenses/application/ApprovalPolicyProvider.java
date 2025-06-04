package com.example.demo.expenses.application;

import com.example.demo.expenses.domain.ApprovalPolicy;

public interface ApprovalPolicyProvider {
    ApprovalPolicy forCompany(String s);
}

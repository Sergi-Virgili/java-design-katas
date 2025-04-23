package com.example.demo.secure_password_kata;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordValidator {

    private final List<PasswordRule> rules;


    public PasswordValidator(List<PasswordRule> rules) {
        this.rules = rules;
    }

    public boolean isSecure(String password) {
        return rules.stream().allMatch(rule -> rule.isValid(password));
    }

}

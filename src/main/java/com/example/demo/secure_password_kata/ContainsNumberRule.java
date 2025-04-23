package com.example.demo.secure_password_kata;

import org.springframework.stereotype.Component;

@Component
public class ContainsNumberRule implements PasswordRule {

    public boolean isValid(String password) {
        return password.matches(".*[0-9].*");
    }
}

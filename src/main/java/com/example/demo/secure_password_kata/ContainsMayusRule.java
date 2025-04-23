package com.example.demo.secure_password_kata;

import org.springframework.stereotype.Component;

@Component
public class ContainsMayusRule implements PasswordRule {

    @Override
    public boolean isValid(String password) {
        return password.matches(".*[A-Z].*");
    }
}
package com.example.demo.secure_password_kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    @Autowired
    private PasswordValidator passwordValidator;

    @Override
    public void run(String... args) throws Exception {
        passwordValidator.isSecure("P2assword");
    }
}

package com.example.demo.secure_password_kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    private final PasswordValidator validator;

    public PasswordValidatorTest() {
        this.validator = new PasswordValidator(List.of(
                new ContainsMayusRule(),
                new MinLengthRule(),
                new ContainsNumberRule()
        ));
    }

    @Test
    void shouldAcceptPasswordThatIs8Length() {
        assertTrue(validator.isSecure("111111111A"));
    }

    @Test
    void shouldRejectPasswordThatIsTooShort() {
        assertFalse(validator.isSecure("Ab1!"));
    }

    @Test
    void shouldRejectPasswordNotContainsSomeMayus() {
        assertFalse(validator.isSecure("b122222222"));
    }

    @Test
    void shouldAcceptPasswordContainsSomeMayus() {
        assertTrue(validator.isSecure("B122222222"));
    }

    @Test
    void shouldRejectPasswordNotContainsNumbers() {
        assertFalse(validator.isSecure("bwerwdfwdffA"));
    }

    @Test
    void shouldAcceptPasswordContainsNumbers() {
        assertTrue(validator.isSecure("bwe1wdfwdffA"));
    }


}
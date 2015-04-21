package com.imaqgroup.test;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class Account {

    private String creditCardNumber;
    private BigDecimal savings = ZERO;

    public Account(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public BigDecimal getSavings() {
        return savings;
    }

    public void addSavings(BigDecimal amount) {
        savings = savings.add(amount);
    }
}

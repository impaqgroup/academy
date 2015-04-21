package com.imaqgroup.test;

import static java.math.BigDecimal.ZERO;

import java.math.BigDecimal;

public class PaybackConfirmation {

    private BigDecimal amount;

    public PaybackConfirmation() {
        this(ZERO);
    }

    public PaybackConfirmation(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

package com.imaqgroup.test;

import java.math.BigDecimal;

public class Purchase {

    private String creditCardNumber;
    private String merchantNumber;
    private BigDecimal amount;

    public Purchase(String creditCardNumber, String merchantNumber, BigDecimal amount) {
        this.creditCardNumber = creditCardNumber;
        this.merchantNumber = merchantNumber;
        this.amount = amount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getMerchantNumber() {
        return merchantNumber;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}

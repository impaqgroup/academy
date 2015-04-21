package com.imaqgroup.test;

import java.math.BigDecimal;

public class Merchant {

    private String number;
    private BigDecimal paybackLimit;
    private BigDecimal paybackPercent;

    public Merchant(String number, BigDecimal paybackLimit, BigDecimal paybackPercent) {
        this.number = number;
        this.paybackLimit = paybackLimit;
        this.paybackPercent = paybackPercent;
    }

    public String getNumber() {
        return number;
    }

    public BigDecimal getPaybackLimit() {
        return paybackLimit;
    }

    public BigDecimal getPaybackPercent() {
        return paybackPercent;
    }
}

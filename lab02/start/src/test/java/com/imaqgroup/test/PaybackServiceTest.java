package com.imaqgroup.test;

import org.junit.Ignore;
import org.junit.Test;

import static java.math.MathContext.UNLIMITED;

import java.math.BigDecimal;


public class PaybackServiceTest {

    static final BigDecimal TEN = new BigDecimal("10.0", UNLIMITED);
    static final String CREDIT_CARD_NUMBER = "8765432112345678";
    static final String MERCHANT_NUMBER = "1234";

    @Test
    @Ignore
    public void unknownCardNumberIsRejected() {

    }

    @Test
    @Ignore
    public void unknownMerchantIsRejected() {

    }

    @Test
    @Ignore
    public void purchaseBelowLimitDoesNotGrantPayback() {

    }

    @Test
    @Ignore
    public void purchaseAtLimitGrantsPayback() {

    }

    @Test
    @Ignore
    public void paybackIsCalculatedAsPercentage() {

    }
}

package com.imaqgroup.test;

import static com.imaqgroup.test.PaybackService.HUNDRED;
import static java.math.BigDecimal.ZERO;
import static java.math.MathContext.UNLIMITED;
import static org.fest.assertions.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class PaybackServiceTest {

    static final BigDecimal TEN = new BigDecimal("10.0", UNLIMITED);
    static final BigDecimal TWENTY = new BigDecimal("20.0", UNLIMITED);

    static final String CREDIT_CARD_NUMBER = "8765432112345678";
    static final String MERCHANT_NUMBER = "1234";

    AccountRepository accountRepository = new AccountRepository();

    MerchantRepository merchantRepository = new MerchantRepository();
    PaybackService service = new PaybackService(accountRepository, merchantRepository);

    @Before
    public void setUp() throws Exception {
        accountRepository.save(new Account(CREDIT_CARD_NUMBER));
        merchantRepository.save(new Merchant(MERCHANT_NUMBER, HUNDRED, TEN.divide(HUNDRED, UNLIMITED)));
    }

    @Test(expected = CreditCardNotFound.class)
    public void unknownCardNumberIsRejected() {
        Purchase purchase = new Purchase("1234567887654321", "9876", TEN);

        service.registerPaybackFor(purchase);
    }

    @Test(expected = MerchantNotFound.class)
    public void unknownMerchantIsRejected() {
        Purchase purchase = new Purchase(CREDIT_CARD_NUMBER, "9876", TEN);

        service.registerPaybackFor(purchase);
    }

    @Test
    public void purchaseBelowLimitDoesNotGrantPayback() {
        Purchase purchase = new Purchase(CREDIT_CARD_NUMBER, MERCHANT_NUMBER, TEN);

        PaybackConfirmation confirmation = service.registerPaybackFor(purchase);

        assertThat(confirmation.getAmount().compareTo(ZERO)).isEqualTo(0);
    }

    @Test
    public void purchaseAtLimitGrantsPayback() {
        Purchase purchase = new Purchase(CREDIT_CARD_NUMBER, MERCHANT_NUMBER, HUNDRED);

        PaybackConfirmation confirmation = service.registerPaybackFor(purchase);

        assertThat(confirmation.getAmount().compareTo(TEN)).isEqualTo(0);
        assertThat(accountRepository.findByCreditCardNo(CREDIT_CARD_NUMBER).getSavings().compareTo(TEN)).isEqualTo(0);
    }

    @Test
    public void paybackIsCalculatedAsPercentage() {
        Purchase purchase = new Purchase(CREDIT_CARD_NUMBER, MERCHANT_NUMBER, new BigDecimal("200.0"));

        PaybackConfirmation confirmation = service.registerPaybackFor(purchase);

        assertThat(confirmation.getAmount().compareTo(TWENTY)).isEqualTo(0);
        assertThat(accountRepository.findByCreditCardNo(CREDIT_CARD_NUMBER).getSavings().compareTo(TWENTY)).isEqualTo(0);
    }
}

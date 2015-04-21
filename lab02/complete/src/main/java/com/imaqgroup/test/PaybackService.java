package com.imaqgroup.test;

import java.math.BigDecimal;

public class PaybackService {

    public static final BigDecimal HUNDRED = new BigDecimal("100.0");

    private final AccountRepository accountRepository;
    private final MerchantRepository merchantRepository;

    public PaybackService(AccountRepository accountRepository, MerchantRepository merchantRepository) {
        this.accountRepository = accountRepository;
        this.merchantRepository = merchantRepository;
    }

    public PaybackConfirmation registerPaybackFor(Purchase purchase) {
        Account account = accountRepository.findByCreditCardNo(purchase.getCreditCardNumber());
        if (account == null) {
            throw new CreditCardNotFound();
        }
        Merchant merchant = merchantRepository.findByNumber(purchase.getMerchantNumber());
        if (merchant == null) {
            throw new MerchantNotFound();
        }
        if (purchase.getAmount().compareTo(merchant.getPaybackLimit()) < 0) {
            return new PaybackConfirmation();
        }
        BigDecimal savings = purchase.getAmount().multiply(merchant.getPaybackPercent());
        account.addSavings(savings);
        return new PaybackConfirmation(savings);
    }
}

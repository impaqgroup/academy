package com.imaqgroup.test;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

    private final Map<String, Account> storage = new HashMap<>();

    public void save(Account account) {
        storage.put(account.getCreditCardNumber(), account);
    }

    public Account findByCreditCardNo(String creditCardNumber) {
        return storage.get(creditCardNumber);
    }
}

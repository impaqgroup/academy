package com.imaqgroup.test;

import java.util.HashMap;
import java.util.Map;

public class MerchantRepository {

    Map<String, Merchant> storage = new HashMap<>();

    public void save(Merchant merchant) {
        storage.put(merchant.getNumber(), merchant);
    }

    public Merchant findByNumber(String merchantNumber) {
        return storage.get(merchantNumber);
    }
}

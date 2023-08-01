package org.example.collections;

import com.ykb.training.atm.Account;
import com.ykb.training.atm.Customer;
import com.ykb.training.atm.ECustomerType;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapRunner {
    public static void main(String[] args) {
        Map<String, Customer> customerMap = new HashMap<>();
        Map<String, Customer> customerMapConcurrent = new ConcurrentHashMap<>();

        customerMap.put("osmanyay", new Customer("osman", "yay", "osmanyay", "123456", Arrays.asList(new Account("TL", new BigDecimal(100))),
                                                 ECustomerType.NORMAL));


        Customer osmanyay = customerMap.get("osmanyay");

    }
}

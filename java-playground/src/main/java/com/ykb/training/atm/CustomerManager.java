package com.ykb.training.atm;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerManager {

    private Map<String, Customer> customerMap = new HashMap<>();


    @Override
    public String toString() {
        return "CustomerManager{" +
               "customerMap=" + customerMap +
               '}';
    }

    public Customer loginCustomer(String username,
                                  String password) {
        Customer customerLoc = customerMap.get(username);
        if (customerLoc != null && password.equals(customerLoc.getPassword())) {
            return customerLoc;
        }
        return null;
    }

    public void readCustomersFromFile() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("customer.txt"));
            customerMap = lines.stream()
                               .map(s -> s.split(","))
                               .map(sa -> new Customer(sa[0],
                                                       sa[1],
                                                       sa[2],
                                                       sa[3],
                                                       parseAccounts(sa[4]),
                                                       ECustomerType.valueOf(sa[5])))
                               .collect(Collectors.toMap(c -> c.getUsername(),
                                                         c -> c));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Account> parseAccounts(String str) {
        String[] split = str.split(";");
        return Arrays.stream(split)
                     .map(s -> s.split("#"))
                     .filter(sa -> sa.length == 3)
                     .map(sa -> new Account(sa[2],
                                            new BigDecimal(sa[1]),
                                            EAccountType.valueOf(sa[0])))
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        CustomerManager customerManager = new CustomerManager();
        customerManager.readCustomersFromFile();
        System.out.println("Customer : " + customerManager);
    }

}

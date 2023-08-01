package com.ykb.training.atm.operations;

import com.ykb.training.atm.Account;
import com.ykb.training.atm.Customer;
import com.ykb.training.atm.EAccountType;
import com.ykb.training.atm.IBankOperation;

import java.util.Scanner;

public class EuroShowAccount implements IBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        Account accountLoc = customerLoc.findAccount(EAccountType.EURO);
        System.out.println(accountLoc);
    }

    @Override
    public String getMenuText() {
        return "EURO hesap görüntüle";
    }
}

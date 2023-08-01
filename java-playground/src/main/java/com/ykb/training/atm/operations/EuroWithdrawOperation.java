package com.ykb.training.atm.operations;

import com.ykb.training.atm.Customer;
import com.ykb.training.atm.EAccountType;

import java.util.Scanner;

public class EuroWithdrawOperation extends AbstractBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        executeWithdrawOperation(scannerLoc,
                                customerLoc,
                                EAccountType.EURO);
    }

    @Override
    public String getMenuText() {
        return "EURO para çek";
    }
}

package com.ykb.training.atm.operations;

import com.ykb.training.atm.Customer;
import com.ykb.training.atm.EAccountType;

import java.util.Scanner;

public class UsdWithdrawOperation extends AbstractBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        executeWithdrawOperation(scannerLoc,
                                customerLoc,
                                EAccountType.DOLAR);
    }

    @Override
    public String getMenuText() {
        return "DOLAR para çek";
    }
}

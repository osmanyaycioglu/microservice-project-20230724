package com.ykb.training.atm.operations;

import com.ykb.training.atm.Customer;
import com.ykb.training.atm.EAccountType;

import java.util.Scanner;

public class TLWithdrawOperation extends AbstractBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        executeWithdrawOperation(scannerLoc,
                                customerLoc,
                                EAccountType.TL);
    }

    @Override
    public String getMenuText() {
        return "TL para çek";
    }
}

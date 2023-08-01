package com.ykb.training.atm.operations;

import com.ykb.training.atm.Customer;
import com.ykb.training.atm.EAccountType;

import java.util.Scanner;

public class UsdDepositOperation extends AbstractBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        executeDepositOperation(scannerLoc,
                                customerLoc,
                                EAccountType.DOLAR);
    }

    @Override
    public String getMenuText() {
        return "Dolar para yatır";
    }
}

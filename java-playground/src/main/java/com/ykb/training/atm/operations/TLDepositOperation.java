package com.ykb.training.atm.operations;

import com.ykb.training.atm.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class TLDepositOperation extends AbstractBankOperation {
    @Override
    public void executeOperation(final Scanner scannerLoc,
                                 final Customer customerLoc) {
        executeDepositOperation(scannerLoc,
                                customerLoc,
                                EAccountType.TL);
    }

    @Override
    public String getMenuText() {
        return "TL para yatır";
    }
}

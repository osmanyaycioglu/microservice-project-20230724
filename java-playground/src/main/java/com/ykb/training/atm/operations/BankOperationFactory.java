package com.ykb.training.atm.operations;

import com.ykb.training.atm.IBankOperation;

import java.util.Arrays;
import java.util.List;

public class BankOperationFactory {

    private static List<IBankOperation> bankOperations = Arrays.asList(new TLDepositOperation(),
                                                                       new TLWithdrawOperation(),
                                                                       new TLShowAccount(),
                                                                       new UsdDepositOperation(),
                                                                       new UsdWithdrawOperation(),
                                                                       new UsdShowAccount(),
                                                                       new EuroDepositOperation(),
                                                                       new EuroWithdrawOperation());

    public static IBankOperation getBankOperation(int index) {
        if (index > bankOperations.size()) {
            return null;
        }
        return bankOperations.get(index - 1);
    }


    public static void printMenu() {
        int index = 1;
        for (IBankOperation bankOperationLoc : bankOperations) {
            System.out.println(index + "-" + bankOperationLoc.getMenuText());
            index++;
        }
    }


}

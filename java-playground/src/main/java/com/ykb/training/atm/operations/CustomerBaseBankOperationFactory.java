package com.ykb.training.atm.operations;

import com.ykb.training.atm.Customer;
import com.ykb.training.atm.IBankOperation;

import java.util.Arrays;
import java.util.List;

public class CustomerBaseBankOperationFactory {

    private List<IBankOperation> bankOperations;

    public CustomerBaseBankOperationFactory(Customer customerParam) {
        bankOperations = customerParam.getCustomerType()
                                      .bankOperations();
    }

    public IBankOperation getBankOperation(int index) {
        if (index > bankOperations.size()) {
            return null;
        }
        return bankOperations.get(index - 1);
    }


    public void printMenu() {
        int index = 1;
        for (IBankOperation bankOperationLoc : bankOperations) {
            System.out.println(index + "-" + bankOperationLoc.getMenuText());
            index++;
        }
    }


}

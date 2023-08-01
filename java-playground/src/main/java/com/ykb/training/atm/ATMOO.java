package com.ykb.training.atm;

import com.ykb.training.atm.operations.BankOperationFactory;
import com.ykb.training.atm.operations.CustomerBaseBankOperationFactory;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATMOO {

    private CustomerManager customerManagerLoc = new CustomerManager();

    public Customer login(Scanner scannerLoc) {
        System.out.println("username : ");
        String username = scannerLoc.nextLine();
        System.out.println("password : ");
        String password = scannerLoc.nextLine();
        Customer customerLoc = customerManagerLoc.loginCustomer(username,
                                                                password);
        return customerLoc;
    }

    public void run() {
        customerManagerLoc.readCustomersFromFile();
        try (Scanner scannerLoc = new Scanner(System.in);) {
            Customer customerLoc = login(scannerLoc);
            if (customerLoc != null) {
                CustomerBaseBankOperationFactory operationFactoryLoc = new CustomerBaseBankOperationFactory(customerLoc);
                loop2:
                while (true) {
                    operationFactoryLoc.printMenu();
                    System.out.println("seçiminiz : ");
                    int index = scannerLoc.nextInt();
                    IBankOperation bankOperationLoc = operationFactoryLoc.getBankOperation(index);
                    if (bankOperationLoc == null){
                        break loop2;
                    }
                    bankOperationLoc.executeOperation(scannerLoc, customerLoc);
                }
            }


            System.out.println("Bye bye");
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

}

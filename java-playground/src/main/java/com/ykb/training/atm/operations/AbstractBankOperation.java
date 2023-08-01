package com.ykb.training.atm.operations;

import com.ykb.training.atm.*;

import java.math.BigDecimal;
import java.util.Scanner;

public abstract class AbstractBankOperation implements IBankOperation {

    public void executeDepositOperation(final Scanner scannerLoc,
                                        final Customer customerLoc,
                                        EAccountType accountTypeParam) {
        Account accountLoc = customerLoc.findAccount(accountTypeParam);
        if (accountLoc != null) {
            System.out.println("Yatıracağınız " + accountTypeParam + " miktarı :");
            BigDecimal amount = scannerLoc.nextBigDecimal();
            if (amount.intValue() > ATM.MAX_DEPOSIT_AMOUNT) {
                System.out.println(ATM.MAX_DEPOSIT_AMOUNT + " dan büyük yatıramazsınız.");
            }
            accountLoc.setAmount(amount.add(accountLoc.getAmount()));
            System.out.println(accountTypeParam + " yatırıldı");
        } else {
            System.out.println(accountTypeParam + " hesabınız yok");
        }
    }

    public void executeWithdrawOperation(final Scanner scannerLoc,
                                        final Customer customerLoc,
                                        EAccountType accountTypeParam) {
        Account accountLoc = customerLoc.findAccount(accountTypeParam);
        if (accountLoc != null) {
            System.out.println("Çekeceğiniz " + accountTypeParam + " miktarı :");
            BigDecimal amount = scannerLoc.nextBigDecimal();
            if (amount.intValue() > ATM.MAX_WITHDRAW_AMOUNT) {
                System.out.println(ATM.MAX_WITHDRAW_AMOUNT + " dan büyük çekemezsiniz.");
            }
            accountLoc.setAmount(amount.add(accountLoc.getAmount()));
            System.out.println(accountTypeParam + " çekim yapıldı");
        } else {
            System.out.println(accountTypeParam + " hesabınız yok");
        }
    }

}

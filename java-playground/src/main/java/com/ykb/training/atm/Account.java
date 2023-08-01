package com.ykb.training.atm;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
    private String accountName;
    private BigDecimal amount;
    private EAccountType accountType;

    public Account(String accountName, BigDecimal amount) {
        this.accountName = accountName;
        this.amount = amount;
    }

    public Account(final String accountNameParam,
                   final BigDecimal amountParam,
                   final EAccountType accountTypeParam) {
        accountName = accountNameParam;
        amount      = amountParam;
        accountType = accountTypeParam;
    }

    public Account() {
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
               "accountName='" + accountName + '\'' +
               ", amount=" + amount +
               '}';
    }

    @Override
    public boolean equals(final Object oParam) {
        if (this == oParam) {
            return true;
        }
        if (oParam == null || getClass() != oParam.getClass()) {
            return false;
        }
        Account that = (Account) oParam;
        return Objects.equals(accountName,
                              that.accountName) && Objects.equals(amount,
                                                                  that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountName,
                            amount);
    }

    public EAccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(final EAccountType accountTypeParam) {
        accountType = accountTypeParam;
    }
}

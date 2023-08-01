package com.ykb.training.atm;

import com.ykb.training.atm.operations.*;

import java.util.Arrays;
import java.util.List;

public enum ECustomerType {
    NORMAL("Normal müşteri",
           1_000_000,
           100_000) {
        public List<IBankOperation> bankOperations() {
            return Arrays.asList(new TLDepositOperation(),
                                 new TLWithdrawOperation(),
                                 new TLShowAccount());
        }

    }, GOLD("Altın müşteri",
            2_000_000,
            200_000) {
        public List<IBankOperation> bankOperations() {
            return Arrays.asList(new TLDepositOperation(),
                                 new TLWithdrawOperation(),
                                 new TLShowAccount(),
                                 new UsdDepositOperation(),
                                 new UsdWithdrawOperation(),
                                 new UsdShowAccount());
        }

    }, PLATINUM("Platinyum müşteri",
                10_000_000,
                1_000_000) {
        public List<IBankOperation> bankOperations() {
            return Arrays.asList(new TLDepositOperation(),
                                 new TLWithdrawOperation(),
                                 new TLShowAccount(),
                                 new UsdDepositOperation(),
                                 new UsdWithdrawOperation(),
                                 new UsdShowAccount(),
                                 new EuroDepositOperation(),
                                 new EuroWithdrawOperation(),
                                 new EuroShowAccount());
        }
    };

    private final int maxWithdraw;
    private final int maxDeposit;

    ECustomerType(final String desc,
                  final int maxWithdraw,
                  final int maxDeposit) {
        this.maxWithdraw = maxWithdraw;
        this.maxDeposit  = maxDeposit;
    }

    public List<IBankOperation> bankOperations() {
        throw new IllegalStateException();
    }

    public int getMaxWithdraw() {
        return maxWithdraw;
    }

    public int getMaxDeposit() {
        return maxDeposit;
    }
}


package com.ykb.training.atm;

import java.util.Scanner;

public interface IBankOperation {

    void executeOperation(final Scanner scannerLoc,
                          final Customer customerLoc);

    String getMenuText();



}

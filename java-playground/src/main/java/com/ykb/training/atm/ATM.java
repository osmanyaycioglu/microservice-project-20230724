package com.ykb.training.atm;

import java.math.BigDecimal;
import java.util.Scanner;

public class ATM {

    public static final int MAX_WITHDRAW_AMOUNT = 100_000;
    private static final int TL_YATIR_INDEX     = 1;
    private static final int TL_CEK_INDEX   = 2;

    private static final int INDEX_WINNER = 1_000_000;

    public static final int MAX_DEPOSIT_AMOUNT = 1_000_000;


    public void run() {
        CustomerManager customerManagerLoc = new CustomerManager();
        customerManagerLoc.readCustomersFromFile();
        try (Scanner scannerLoc = new Scanner(System.in);) {
            System.out.println("username : ");
            String username = scannerLoc.nextLine();
            System.out.println("password : ");
            String password = scannerLoc.nextLine();
            Customer customerLoc = customerManagerLoc.loginCustomer(username,
                                                                    password);
            if (customerLoc != null) {
                loop2:
                while (true) {
                    System.out.println(TL_YATIR_INDEX + "-TL para yatır");
                    System.out.println(TL_CEK_INDEX + "-TL para çek");
                    System.out.println("3-DOLAR para yatır");
                    System.out.println("4-DOLAR para çek");
                    System.out.println("5-EURO para yatır");
                    System.out.println("6-EURO para çek");
                    System.out.println("7-TL hesap bilgisi");
                    System.out.println("seçiminiz:");
                    int index = scannerLoc.nextInt();
                    if (index > 7) {
                        break loop2;
                    }
                    if (index == INDEX_WINNER) {
                        System.out.println("index kazandı");
                    }
                    switch (index) {
                        case TL_YATIR_INDEX: {
                            deposit(scannerLoc,
                                    customerLoc,
                                    EAccountType.TL);
                            break;
                        }
                        case TL_CEK_INDEX: {
                            Account accountLoc = customerLoc.findAccount(EAccountType.TL);
                            if (accountLoc != null) {
                                System.out.println("Çekeceğiniz TL miktarı :");
                                BigDecimal amount = scannerLoc.nextBigDecimal();
                                accountLoc.setAmount(accountLoc.getAmount()
                                                               .subtract(amount));
                                System.out.println("TL yatırıldı");
                            } else {
                                System.out.println("TL hesabınız yok");
                            }
                            break;
                        }
                        case 3: {
                            deposit(scannerLoc,
                                    customerLoc,
                                    EAccountType.DOLAR);
                            break;
                        }
                        case 4: {
                            Account accountLoc = customerLoc.findAccount(EAccountType.DOLAR);
                            if (accountLoc != null) {
                                System.out.println("Çekeceğiniz DOLAR miktarı :");
                                BigDecimal amount = scannerLoc.nextBigDecimal();
                                accountLoc.setAmount(accountLoc.getAmount()
                                                               .subtract(amount));
                                System.out.println("DOLAR yatırıldı");
                            } else {
                                System.out.println("DOLAR hesabınız yok");
                            }
                            break;
                        }
                        case 5: {
                            deposit(scannerLoc,
                                    customerLoc,
                                    EAccountType.EURO);
                            break;
                        }
                        case 6: {
                            Account accountLoc = customerLoc.findAccount(EAccountType.EURO);
                            if (accountLoc != null) {
                                System.out.println("Çekeceğiniz EURO miktarı :");
                                BigDecimal amount = scannerLoc.nextBigDecimal();
                                accountLoc.setAmount(accountLoc.getAmount()
                                                               .subtract(amount));
                                System.out.println("EURO yatırıldı");
                            } else {
                                System.out.println("EURO hesabınız yok");
                            }
                            break;
                        }
                        case 7: {
                            Account accountLoc = customerLoc.findAccount(EAccountType.TL);
                            System.out.println(accountLoc);
                        }
                    }
                }
            }


            System.out.println("Bye bye");
        } catch (Exception exp) {
            exp.printStackTrace();
        }

    }

    private static void deposit(final Scanner scannerLoc,
                                final Customer customerLoc,
                                EAccountType accountTypeParam) {
        Account accountLoc = customerLoc.findAccount(accountTypeParam);
        if (accountLoc != null) {
            System.out.println("Yatıracağınız " + accountTypeParam + " miktarı :");
            BigDecimal amount = scannerLoc.nextBigDecimal();
            if (amount.intValue() > MAX_DEPOSIT_AMOUNT) {
                System.out.println(MAX_DEPOSIT_AMOUNT + " dan büyük yatıramazsınız.");
            }
            accountLoc.setAmount(amount.add(accountLoc.getAmount()));
            System.out.println(accountTypeParam + " yatırıldı");
        } else {
            System.out.println(accountTypeParam + " hesabınız yok");
        }
    }

}

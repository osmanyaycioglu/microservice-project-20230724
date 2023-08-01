package com.ykb.training.atm;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String        name;
    private String        surname;
    private String        username;
    private String        password;
    private List<Account> account;
    private ECustomerType customerType;

    public Customer(String name,
                    String surname,
                    String username,
                    String password,
                    List<Account> account,
                    ECustomerType customerType) {
        this.name         = name;
        this.surname      = surname;
        this.username     = username;
        this.password     = password;
        this.account      = account;
        this.customerType = customerType;
    }

    public Account findAccount(EAccountType eAccountTypeParam) {
        if (account != null) {
            for (Account accountLoc : account) {
                if (accountLoc.getAccountType() == eAccountTypeParam) {
                    return accountLoc;
                }
            }
        }
        return null;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }

    public ECustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(final ECustomerType customerTypeParam) {
        customerType = customerTypeParam;
    }

    @Override
    public String toString() {
        return "Customer{" +
               "name='" + name + '\'' +
               ", surname='" + surname + '\'' +
               ", username='" + username + '\'' +
               ", password='" + password + '\'' +
               ", account=" + account +
               ", customerType=" + customerType +
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
        Customer that = (Customer) oParam;
        return Objects.equals(name,
                              that.name)
               && Objects.equals(surname,
                                 that.surname)
               && Objects.equals(username,
                                 that.username)
               && Objects.equals(password,
                                 that.password)
               && Objects.equals(account,
                                 that.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            surname,
                            username,
                            password,
                            account);
    }
}

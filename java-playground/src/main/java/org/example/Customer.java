package org.example;

public class Customer {
    private String name;
    private String surname;
    private int accessCount;
    private Integer internalCount;

    public static Customer createNewCustomer(){
        return new Customer();
    }

    Customer() {
    }

    public Customer(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Customer(String name, String surname, int accessCount) {
        this.name = name;
        this.surname = surname;
        this.accessCount = accessCount;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        int a = 100;
        Integer b = 100;
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public Customer setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}

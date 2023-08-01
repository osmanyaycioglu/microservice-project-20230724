package org.example;


import java.time.LocalDateTime;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Customer customer = new Customer("osman", "yaycio");

        Customer customer1 = new Customer().setName("osman").setSurname("yaycio");

        Customer customer2 = Customer.createNewCustomer().setName("osman").setSurname("yaycio");

        Customer customer3 = new Customer();
        customer3.setName("osman");
        System.out.printf("osman test");
        int i = 100;
        customer3.setSurname("yaycio");

        LocalDateTime localDateTime = LocalDateTime.now().plusDays(3).minusSeconds(30);

        String str = "osman test";
        String son = str.substring(3).toUpperCase().concat("son");
        str = "deneme";

        CustomerIm customerIm = CustomerIm.getBuilder().setName("osman").setSurname("yaycioglu").setAccessCount(10).build();

    }
}

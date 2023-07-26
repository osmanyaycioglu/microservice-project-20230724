package com.training.micro.service.services.models;

import com.training.micro.service.rest.models.AddressRest;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@SequenceGenerator(name = "customer_seq",allocationSize = 1,sequenceName = "customer_seq")
public class Customer {
    @Id
    @GeneratedValue(generator = "customer_seq",strategy = GenerationType.SEQUENCE)
    private Long      customerId;
    private String    uuid;
    private String    name;
    private String    surname;
    private Integer   weight;
    private Integer   height;
    private LocalDate birthdate;
    private String    username;
    private String    password;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Address   address;
}

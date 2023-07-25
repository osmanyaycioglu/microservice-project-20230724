package com.training.micro.service.rest.models;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    private String name;
    private String surname;
    private Integer weight;
    private Integer height;
    private LocalDate birthdate;
}

package com.training.micro.service.rest.models;

import com.training.micro.service.valiidation.NotContainsStr;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CustomerQuery {
    private String name;
    private String surname;
    private Integer weight;
    private Integer height;
    private LocalDate birthdate;
}

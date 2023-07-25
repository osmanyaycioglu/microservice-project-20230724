package com.training.micro.service.rest.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Address {
    @NotNull
    @NotEmpty
    private String city;
    @NotNull
    @NotEmpty
    private String street;

}

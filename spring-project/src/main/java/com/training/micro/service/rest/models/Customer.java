package com.training.micro.service.rest.models;

import com.training.micro.service.valiidation.NotContainsStr;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Customer {
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15,message = "isim böyle olmaz {min} ile {max} arasında bunu bana ver")
    private String name;
    @NotNull
    @NotEmpty
    @Size(min = 2,max = 15)
    private String surname;
    @Min(10)
    @Max(500)
    private Integer weight;
    @Min(50)
    @Max(300)
    private Integer height;
    @Past
    private LocalDate birthdate;
    @NotContainsStr(value = {"abc","qwe","123"})
    @NotNull
    @NotEmpty
    @Size(min = 6,max = 12)
    private String username;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;

    @Valid
    private Address address;
}

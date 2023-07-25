package com.training.micro.service.rest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class HelloResponse {
    private String description;
    private Integer counter;
    private String responseType;
    private LocalDateTime reponseTime;

    public HelloResponse() {
    }
}

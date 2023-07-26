package com.training.micro.service.kitchen.rest.models;

import lombok.Data;

import java.util.List;

@Data
public class ReservationInfo {
    private String orderId;
    private String customerId;
    private String phoneNumber;
    private List<String> meals;

}

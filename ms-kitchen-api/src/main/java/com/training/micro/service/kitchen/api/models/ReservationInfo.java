package com.training.micro.service.kitchen.api.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
public class ReservationInfo {
    private String orderId;
    private String customerId;
    private String phoneNumber;
    private List<String> meals;

}

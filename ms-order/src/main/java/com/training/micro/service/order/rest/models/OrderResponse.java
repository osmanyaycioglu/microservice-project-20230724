package com.training.micro.service.order.rest.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class OrderResponse {
    private String orderId;
    private LocalDateTime deliveryTime;

    public OrderResponse() {
    }
}

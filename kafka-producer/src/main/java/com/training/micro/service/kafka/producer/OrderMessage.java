package com.training.micro.service.kafka.producer;

import lombok.Data;

@Data
public class OrderMessage {
    private String oderId;
    private String customerPhone;
    private String address;
}

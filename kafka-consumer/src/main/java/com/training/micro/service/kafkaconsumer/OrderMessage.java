package com.training.micro.service.kafkaconsumer;

import lombok.Data;

@Data
public class OrderMessage {
    private String oderId;
    private String customerPhone;
    private String address;
}

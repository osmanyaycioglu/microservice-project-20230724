package com.training.micro.service.kitchen.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(setterPrefix = "with")
@AllArgsConstructor
public class ReservationStatus {
    private String reservationId;
    private LocalDateTime reservationEnds;
    private String orderId;
    private String desc;

    public ReservationStatus() {
    }
}

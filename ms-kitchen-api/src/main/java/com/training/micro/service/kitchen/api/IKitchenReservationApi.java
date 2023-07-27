package com.training.micro.service.kitchen.api;

import com.training.micro.service.kitchen.api.models.ReservationInfo;
import com.training.micro.service.kitchen.api.models.ReservationStatus;
import org.springframework.web.bind.annotation.*;

public interface IKitchenReservationApi {
    @PostMapping("/api/v1/kitchen/reservation/reserve")
    public ReservationStatus reserveMeal(@RequestBody ReservationInfo reservationInfoParam);

    @GetMapping("/api/v1/kitchen/reservation/tester")
    public String testMethod(@RequestParam("name") String name,
                             @RequestParam("sname") String surname);
}

package com.training.micro.service.kitchen.rest;

import com.training.micro.service.kitchen.rest.models.ReservationInfo;
import com.training.micro.service.kitchen.rest.models.ReservationStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/api/v1/kitchen/reservation")
public class KitchenReservtionController {
//    private List<ReservationInfo> reservationInfos = Collections.synchronizedList(new ArrayList<>());
//    private AtomicInteger         counter          = new AtomicInteger();
//    private Map<String,ReservationInfo> stringReservationInfoMap = new ConcurrentHashMap<>(1_000_000,0.9F,1_000);

    public ReservationStatus reserveMeal(ReservationInfo reservationInfoParam) {
//        Lock lockLoc = new ReentrantLock(true);
//
//        synchronized (counter){
//            System.out.println("One thread");
//        }
//        for (ReservationInfo reservationInfoLoc : reservationInfos) {
//
//        }
//        int iLoc = counter.incrementAndGet();
//        reservationInfos.add(reservationInfoParam);
        return ReservationStatus.builder()
                                .withReservationId(UUID.randomUUID()
                                                       .toString())
                                .withReservationEnds(LocalDateTime.now()
                                                                  .plusHours(1))
                                .withOrderId(reservationInfoParam.getOrderId())
                                .build();
    }

}

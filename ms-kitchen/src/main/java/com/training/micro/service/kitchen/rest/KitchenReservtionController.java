package com.training.micro.service.kitchen.rest;

import com.training.micro.service.kitchen.api.IKitchenReservationApi;
import com.training.micro.service.kitchen.api.models.ReservationInfo;
import com.training.micro.service.kitchen.api.models.ReservationStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
public class KitchenReservtionController implements IKitchenReservationApi {
//    private List<ReservationInfo> reservationInfos = Collections.synchronizedList(new ArrayList<>());
//    private AtomicInteger         counter          = new AtomicInteger();
//    private Map<String,ReservationInfo> stringReservationInfoMap = new ConcurrentHashMap<>(1_000_000,0.9F,1_000);

    @Value("${server.port}")
    private int port;

    public ReservationStatus reserveMeal(@RequestBody ReservationInfo reservationInfoParam) {
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
                                .withDesc("My port : " + port)
                                .build();
    }

    public String testMethod(@RequestParam("name") String name,
                             @RequestParam("sname") String surname) {
        return "Test " + name + " " + surname;
    }

}

package com.training.micro.service.order.services.integrations;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.training.micro.service.kitchen.api.models.ReservationInfo;
import com.training.micro.service.kitchen.api.models.ReservationStatus;
import com.training.micro.service.order.rest.models.OrderRequest;
import com.training.micro.service.order.rest.models.OrderResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class KitchenReservationIntegration {

    private static final Logger logger = LoggerFactory.getLogger(KitchenReservationIntegration.class);

    private final RestTemplate                   restTemplate;
    private final EurekaClient                   eurekaClient;
    private final IKitchenReservationIntegration kitchenReservationIntegration;
    private       AtomicInteger                  indexCounter = new AtomicInteger();

    @Retry(name = "retyXyz", fallbackMethod = "reserveMeals3Fallback")
    //@CircuitBreaker(name = "kitchencb", fallbackMethod = "reserveMeals3Fallback")
    public OrderResponse reserveMeals3(final OrderRequest orderRequestParam) {
        ReservationInfo re = ReservationInfo.builder()
                                            .withCustomerId("XY1002")
                                            .withOrderId(orderRequestParam.getOrderId())
                                            .withPhoneNumber(orderRequestParam.getPhoneNumber())
                                            .withMeals(orderRequestParam.getMeals())
                                            .build();
        ReservationStatus reservationStatusLoc = kitchenReservationIntegration.reserveMeal(re);
        System.out.println("Reservation : " + reservationStatusLoc);
        return OrderResponse.builder()
                            .withOrderId(orderRequestParam.getOrderId())
                            .withDeliveryTime(reservationStatusLoc.getReservationEnds())
                            .build();
    }

    public OrderResponse reserveMeals3Fallback(final OrderRequest orderRequestParam,
                                               Throwable throwableParam) {
        return null;
    }


    public OrderResponse reserveMeals(final OrderRequest orderRequestParam) {
        if (logger.isDebugEnabled()) {
            logger.debug("Input : " + orderRequestParam);
        }

        //logger.debug("Input : {} " , orderRequestParam);

        ReservationInfo re = ReservationInfo.builder()
                                            .withCustomerId("XY1002")
                                            .withOrderId(orderRequestParam.getOrderId())
                                            .withPhoneNumber(orderRequestParam.getPhoneNumber())
                                            .withMeals(orderRequestParam.getMeals())
                                            .build();

        ReservationStatus reservationStatusLoc = null;
        try {
            reservationStatusLoc = restTemplate.postForObject("http://KITCHEN/api/v1/kitchen/reservation/reserve",
                                                              re,
                                                              ReservationStatus.class);
        } catch (RestClientResponseException eParam) {
            logger.error("Error : " + eParam.getMessage(),
                         eParam);
            HttpStatusCode statusCodeLoc = eParam.getStatusCode();
            throw eParam;
        }
        System.out.println("Reservation : " + reservationStatusLoc);
        return OrderResponse.builder()
                            .withOrderId(orderRequestParam.getOrderId())
                            .withDeliveryTime(reservationStatusLoc.getReservationEnds())
                            .build();
    }


    public OrderResponse reserveMeals2(final OrderRequest orderRequestParam) {
        ReservationInfo re = ReservationInfo.builder()
                                            .withCustomerId("XY1002")
                                            .withOrderId(orderRequestParam.getOrderId())
                                            .withPhoneNumber(orderRequestParam.getPhoneNumber())
                                            .withMeals(orderRequestParam.getMeals())
                                            .build();
        Application        kitchenLoc   = eurekaClient.getApplication("KITCHEN");
        List<InstanceInfo> instancesLoc = kitchenLoc.getInstances();
        for (InstanceInfo instanceLoc : instancesLoc) {
            System.out.println("instance : " + instanceLoc.getIPAddr() + ":" + instanceLoc.getPort());
        }
        int iLoc  = indexCounter.incrementAndGet();
        int index = iLoc % instancesLoc.size();

        InstanceInfo instanceInfoLoc = instancesLoc.get(index);
        RestTemplate restTemplateLoc = new RestTemplate();

        ReservationStatus reservationStatusLoc = restTemplateLoc.postForObject("http://"
                                                                               + instanceInfoLoc.getIPAddr()
                                                                               + ":"
                                                                               + instanceInfoLoc.getPort()
                                                                               + "/api/v1/kitchen/reservation/reserve",
                                                                               re,
                                                                               ReservationStatus.class);
        System.out.println("Reservation : " + reservationStatusLoc);
        return OrderResponse.builder()
                            .withOrderId(orderRequestParam.getOrderId())
                            .withDeliveryTime(reservationStatusLoc.getReservationEnds())
                            .build();
    }

}

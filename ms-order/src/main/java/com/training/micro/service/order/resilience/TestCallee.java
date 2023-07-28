package com.training.micro.service.order.resilience;

import com.training.micro.service.order.rest.models.OrderResponse;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestCallee {

    private int counter = 0;

    public OrderResponse hello() {
        counter++;
        System.out.println("Hello : " + counter);
        if (counter % 10 == 0) {
            throw new IllegalArgumentException();
        }
        if (counter > 10 && counter < 30) {
            throw new IllegalArgumentException();
        }
        return OrderResponse.builder()
                            .withOrderId("" + counter)
                            .withDeliveryTime(LocalDateTime.now())
                            .build();
    }

}

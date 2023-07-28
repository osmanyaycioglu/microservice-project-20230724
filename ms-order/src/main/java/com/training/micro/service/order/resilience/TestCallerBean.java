package com.training.micro.service.order.resilience;

import com.training.micro.service.order.rest.models.OrderResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TestCallerBean {

    @Autowired
    private TestCallee testCallee;

    //@Retry(name = "retyXyz", fallbackMethod = "beginFallback")
    @CircuitBreaker(name = "kitchencb", fallbackMethod = "beginFallback")
    public OrderResponse begin() {
        System.out.println("Begin Called");
        OrderResponse helloLoc = testCallee.hello();
        System.out.println("Response : " + helloLoc);
        return helloLoc;
    }

    public OrderResponse beginFallback(Throwable throwableParam) {
        System.out.println("Fallback : " + throwableParam.getClass()
                                                         .getSimpleName());
        return OrderResponse.builder()
                            .withOrderId("XXXXXX")
                            .withDeliveryTime(LocalDateTime.now())
                            .build();
    }

}

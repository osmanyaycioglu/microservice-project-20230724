package com.training.micro.service.order.resilience;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;

import java.util.function.Predicate;

public class ChooseRety implements Predicate<Throwable> {

    @Override
    public boolean test(final Throwable throwableParam) {
        if (throwableParam instanceof RestClientResponseException) {
            RestClientResponseException rcre = (RestClientResponseException) throwableParam;
            return true;
        }
        return true;
    }

}

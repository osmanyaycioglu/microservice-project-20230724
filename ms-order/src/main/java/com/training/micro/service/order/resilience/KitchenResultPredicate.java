package com.training.micro.service.order.resilience;

import com.training.micro.service.order.rest.models.OrderResponse;

import java.util.function.Predicate;

public class KitchenResultPredicate implements Predicate<OrderResponse> {
    @Override
    public boolean test(final OrderResponse orderResponseParam) {
        if (orderResponseParam.getOrderId() == null){
            return true;
        }
        return false;
    }
}

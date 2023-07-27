package com.training.micro.service.order.services;
import com.training.micro.service.order.rest.models.OrderRequest;
import com.training.micro.service.order.rest.models.OrderResponse;
import com.training.micro.service.order.services.integrations.KitchenReservationIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderProcessService {

    @Autowired
    private KitchenReservationIntegration kitchenReservationIntegration;

    public OrderResponse placeOrder(OrderRequest orderRequestParam){
        orderRequestParam.setOrderId(UUID.randomUUID().toString());
        return kitchenReservationIntegration.reserveMeals3(orderRequestParam);
    }

}

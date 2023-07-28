package com.training.micro.service.order.services;

import com.training.micro.service.order.rest.models.OrderRequest;
import com.training.micro.service.order.rest.models.OrderResponse;
import com.training.micro.service.order.services.integrations.KitchenReservationIntegration;
import com.training.micro.service.order.services.integrations.NotifySMSIntegration;
import com.training.micro.service.order.services.integrations.models.NotifyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderProcessService {

    @Autowired
    private KitchenReservationIntegration kitchenReservationIntegration;
    @Autowired
    private NotifySMSIntegration          notifySMSIntegration;

    public OrderResponse placeOrder(OrderRequest orderRequestParam) {
        orderRequestParam.setOrderId(UUID.randomUUID()
                                         .toString());
        OrderResponse orderResponseLoc = kitchenReservationIntegration.reserveMeals3(orderRequestParam);
        notifySMSIntegration.sendMessage(new NotifyMessage("Order : "
                                                           + orderRequestParam.getOrderId()
                                                           + " hazırlanıyor",
                                                           orderRequestParam.getPhoneNumber()));
        return orderResponseLoc;
    }

}

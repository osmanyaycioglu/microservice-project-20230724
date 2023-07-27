package com.training.micro.service.order.services.integrations;

import com.training.micro.service.kitchen.api.IKitchenReservationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("KITCHEN")
public interface IKitchenReservationIntegration extends IKitchenReservationApi {

}


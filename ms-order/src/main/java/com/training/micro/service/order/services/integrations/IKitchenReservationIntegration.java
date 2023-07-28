package com.training.micro.service.order.services.integrations;

import com.training.micro.service.kitchen.api.IKitchenReservationApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("API-RESTAURANT")
public interface IKitchenReservationIntegration extends IKitchenReservationApi {

}


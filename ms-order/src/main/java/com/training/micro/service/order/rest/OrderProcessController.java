package com.training.micro.service.order.rest;

import com.training.micro.service.order.rest.models.OrderRequest;
import com.training.micro.service.order.rest.models.OrderResponse;
import com.training.micro.service.order.services.OrderProcessService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order/process")
public class OrderProcessController {

    private OrderProcessService orderProcessService;

    public OrderProcessController(final OrderProcessService orderProcessServiceParam) {
        orderProcessService = orderProcessServiceParam;
    }

    @PostMapping("/place")
    public OrderResponse placeOrder(@Valid @RequestBody OrderRequest orderRequestParam){
        return orderProcessService.placeOrder(orderRequestParam);
    }
}

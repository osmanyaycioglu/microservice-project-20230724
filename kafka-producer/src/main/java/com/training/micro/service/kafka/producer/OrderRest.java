package com.training.micro.service.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/order")
public class OrderRest {

    @Autowired
    private KafkaTemplate<String, OrderMessage> kafkaTemplate;

    @PostMapping("/place")
    public String place(@RequestBody OrderMessage orderMessageParam) throws ExecutionException, InterruptedException {
        CompletableFuture<SendResult<String, OrderMessage>> topictestLoc = kafkaTemplate.send("topictest",
                                                                                              "key1",
                                                                                              orderMessageParam);
        SendResult<String, OrderMessage> stringOrderMessageSendResultLoc = topictestLoc.get();

        return stringOrderMessageSendResultLoc.toString();
    }
}

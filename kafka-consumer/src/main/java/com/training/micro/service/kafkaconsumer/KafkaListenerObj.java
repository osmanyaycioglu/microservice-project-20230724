package com.training.micro.service.kafkaconsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListenerObj {


    @KafkaListener(topics = "topictest",groupId = "micro-group")
    public void handleOrder(String orderMessageParam){
        System.out.println("I have order : " + orderMessageParam);
    }

}

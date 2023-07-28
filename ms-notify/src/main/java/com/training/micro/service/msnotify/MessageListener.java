package com.training.micro.service.msnotify;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-message-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "message-exchange",
                    durable = "true",
                    autoDelete = "false",
                    type = ExchangeTypes.DIRECT),
            key = "sms-send"
    ))
    @SendTo("message-response-exchange/sms-send-response")
    public String handleSMS(NotifyMessage notifyMessageParam) {
        System.out.println("I got  : " + notifyMessageParam);
        return "Message sent : " + notifyMessageParam;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.sms.#"
    ))
    public void handleTopicSMS(NotifyMessage message){
        System.out.println("Received Topic SMS : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "email-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.email.#"
    ))
    public void handleTopicEmail(NotifyMessage message){
        System.out.println("Received Topic EMAIL : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "all-tr-message-q",durable = "true",autoDelete = "false"),
            exchange = @Exchange(name = "message-topic-exchange",durable = "true",autoDelete = "false",type = ExchangeTypes.TOPIC),
            key = "send.#"
    ))
    public void handleAll(NotifyMessage message){
        System.out.println("Received All EMAIL : " + message);
    }


}

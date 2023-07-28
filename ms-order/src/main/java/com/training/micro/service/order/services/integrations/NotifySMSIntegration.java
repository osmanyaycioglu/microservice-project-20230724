package com.training.micro.service.order.services.integrations;

import com.training.micro.service.order.services.integrations.models.NotifyMessage;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifySMSIntegration {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    public void sendMessage(NotifyMessage notifyMessageParam) {
        rabbitTemplate.convertAndSend("message-exchange",
                                      "sms-send",
                                      notifyMessageParam);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "sms-message-response-q", durable = "true", autoDelete = "false"),
            exchange = @Exchange(name = "message-response-exchange",
                    durable = "true",
                    autoDelete = "false",
                    type = ExchangeTypes.DIRECT),
            key = "sms-send-response"
    ))
    public void handleSMS(String sendResult) {
        System.out.println("Result  : " + sendResult);
    }

}

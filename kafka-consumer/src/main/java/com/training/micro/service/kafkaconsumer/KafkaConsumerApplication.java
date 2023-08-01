package com.training.micro.service.kafkaconsumer;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableKafka
public class KafkaConsumerApplication {

    @Autowired
    private KafkaProperties kafkaProperties;

    @Value(value = "${spring.kafka.consumer.bootstrap-servers}")
    private String bootstrapAddress;


    @Bean
    public ConsumerFactory<String, OrderMessage> consumerFactory() {
        JsonDeserializer<OrderMessage> jsonDeserializerLoc = new JsonDeserializer<>(OrderMessage.class);
        jsonDeserializerLoc.setRemoveTypeHeaders(false);
        jsonDeserializerLoc.addTrustedPackages("*");
        jsonDeserializerLoc.setUseTypeMapperForKey(true);

        StringDeserializer stringDeserializerLoc = new StringDeserializer();


        Map<String, Object> propertiesLoc = kafkaProperties.buildConsumerProperties();
        propertiesLoc.put(ConsumerConfig.GROUP_ID_CONFIG,
                          "micro-group");

        DefaultKafkaConsumerFactory<String, OrderMessage> dkf = new DefaultKafkaConsumerFactory<>(propertiesLoc,
                                                                                                  stringDeserializerLoc,
                                                                                                  jsonDeserializerLoc);
        return dkf;
    }


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>(kafkaProperties.buildAdminProperties());
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,
                    bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic("topictest",
                            2,
                            (short) 1);
    }


    public static void main(String[] args) {
        SpringApplication.run(KafkaConsumerApplication.class,
                              args);
    }

}

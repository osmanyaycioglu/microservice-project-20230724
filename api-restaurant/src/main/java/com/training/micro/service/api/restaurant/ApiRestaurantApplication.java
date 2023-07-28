package com.training.micro.service.api.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiRestaurantApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiRestaurantApplication.class,
                              args);
    }

}

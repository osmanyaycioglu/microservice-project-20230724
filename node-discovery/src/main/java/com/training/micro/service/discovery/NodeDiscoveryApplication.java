package com.training.micro.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableEurekaServer
@EnableScheduling
public class NodeDiscoveryApplication {

    @Scheduled(fixedDelay = 10_000)
    public void method(){
        System.out.println("scheduled");
    }

    public static void main(String[] args) {
        SpringApplication.run(NodeDiscoveryApplication.class,
                              args);
    }

}

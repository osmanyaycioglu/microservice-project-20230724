package com.training.micro.service.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class NodeConfigurationApplication {

    public static void main(String[] args) {
        SpringApplication.run(NodeConfigurationApplication.class,
                              args);
    }

}

package com.training.micro.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Controller
//@Repository
//@Service
@Configuration
public class HelloConfig {

    @Bean
    public HelloWorld helloWorldCoreBean(){
        return new HelloWorld();
    }

    @Bean
    public HelloWorld helloWorldCoreBeanEx(){
        return new HelloWorld();
    }

}

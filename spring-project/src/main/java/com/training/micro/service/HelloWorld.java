package com.training.micro.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Scope("prototype")
public class HelloWorld {

    private int counter = 0;

    public String hello(String name) {
        counter++;
        return "Hello " + name;
    }

}

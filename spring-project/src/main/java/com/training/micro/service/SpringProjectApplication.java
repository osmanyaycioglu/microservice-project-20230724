package com.training.micro.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringProjectApplication {

    @Autowired
    @Qualifier("helloWorld")
    private HelloWorld helloWorld1;
    private HelloWorld helloWorld2;
    private HelloWorld helloWorld3;

    public SpringProjectApplication() {
    }

    @Autowired
    public SpringProjectApplication(@Qualifier("helloWorld") final HelloWorld helloWorldParam) {
        helloWorld2 = helloWorldParam;
    }

    @Autowired
    public void xyz(@Qualifier("helloWorldCoreBean") HelloWorld helloWorldParam){
        helloWorld3 = helloWorldParam;
    }

    @PostConstruct
    public void init(){
        System.out.println("init called");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy called");
    }

    public void sayHello(String name){
        System.out.println(helloWorld1.hello(name));
        System.out.println(helloWorld2.hello(name));
        System.out.println(helloWorld3.hello(name));

        System.out.println("counter " + helloWorld1.getCounter());
        System.out.println("counter " + helloWorld2.getCounter());
        System.out.println("counter " + helloWorld3.getCounter());
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext contextLoc = SpringApplication.run(SpringProjectApplication.class,
                                                                      args);
        SpringProjectApplication beanLoc = contextLoc.getBean(SpringProjectApplication.class);
        beanLoc.sayHello("osman");
    }

}

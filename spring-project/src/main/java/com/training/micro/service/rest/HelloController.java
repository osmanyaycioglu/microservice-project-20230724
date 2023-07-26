package com.training.micro.service.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.micro.service.rest.models.CustomerRest;
import com.training.micro.service.rest.models.HelloResponse;
import com.training.micro.service.valiidation.NotContainsStr;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Operation(summary = "hello to all", description = "uzun descrion"
                                                       + " devamı")
    @ApiResponses({@ApiResponse(description = "deneme response", responseCode = "417")})
    @GetMapping("/hello1")
    public String hello1() {
        return "Hello world 1";
    }

    @PostMapping("/hello1")
    public String hello1a() {
        return "Hello world 1 POST";
    }

    @PutMapping("/hello1")
    public String hello1b() {
        return "Hello world 1 PUT";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello world 2";
    }

    @GetMapping("/hello3/{isim}")
    public String hello3(@PathVariable("isim") String name) {
        return "Hello world 3 " + name;
    }

    @GetMapping("/hello4/{isim}/xyz/{soy}")
    public String hello4(@PathVariable("isim") String name,
                         @PathVariable("soy") String surname) {
        return "Hello world 4 " + name + " " + surname;
    }

    @GetMapping("/hello5")
    public String hello5(@RequestParam("name") String name) {
        return "Hello world 5 " + name;
    }

    @GetMapping("/hello6")
    public String hello6(@NotContainsStr({"abc"}) @RequestParam("name") String name,
                         @RequestParam("surname") String surname) {
        return "Hello world 6 " + name + " " + surname;
    }

    @GetMapping("/hello7/{isim}")
    public String hello7(@PathVariable("isim") String name,
                         @RequestParam("soy") String surname) {
        return "Hello world 7 " + name + " " + surname;
    }

    @PostMapping("/hello8")
    public String hello8(@RequestBody CustomerRest customerParam) {
        return "Hello 8 " + customerParam;
    }

    @PostMapping("/hello9")
    public HelloResponse hello9(@RequestBody CustomerRest customerParam) {
        return HelloResponse.builder()
                            .withCounter(10)
                            .withDescription("Customer eklendi")
                            .withResponseType("Success")
                            .withReponseTime(LocalDateTime.now())
                            .build();
    }

    @PostMapping("/hello10")
    public ResponseEntity<HelloResponse> hello10(@RequestBody CustomerRest customerParam) {
        return ResponseEntity.status(217)
                             .header("rest-reponse",
                                     "osman")
                             .body(HelloResponse.builder()
                                                .withCounter(10)
                                                .withDescription("Customer eklendi")
                                                .withResponseType("Success")
                                                .withReponseTime(LocalDateTime.now())
                                                .build());
    }

    @PostMapping("/hello11/{operation}")
    public ResponseEntity<?> hello11(@PathVariable("operation") String operation,
                                     HttpServletRequest httpServletRequestParam) throws IOException {
        switch (operation) {
            case "add" -> {
                httpServletRequestParam.getParameter("xyz");
            }
            case "suspend" -> {
                ObjectMapper objectMapperLoc = new ObjectMapper();
                CustomerRest customerLoc = objectMapperLoc.readValue(httpServletRequestParam.getInputStream(),
                                                                     CustomerRest.class);
            }
        }
        return ResponseEntity.status(217)
                             .header("rest-reponse",
                                     "osman")
                             .body(HelloResponse.builder()
                                                .withCounter(10)
                                                .withDescription("Customer eklendi")
                                                .withResponseType("Success")
                                                .withReponseTime(LocalDateTime.now())
                                                .build());
    }

}

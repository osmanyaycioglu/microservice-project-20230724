package com.training.micro.service.rest;

import com.training.micro.service.rest.models.Customer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/provision")
@Valid
public class CustomerProvisionController {

    @PostMapping("/add")
    public String add(@Valid @RequestBody Customer customerParam){
        return "OK";
    }

    @GetMapping("/suspend")
    public Customer suspendCustomer(@NotNull @RequestParam("cid") Long customerId){
        return null;
    }

    @PostMapping("/update")
    public String update(@RequestBody Customer customerParam){
        return "OK";
    }



}

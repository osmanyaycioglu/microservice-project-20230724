package com.training.micro.service.rest;

import com.training.micro.service.rest.models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/provision")
public class CustomerProvisionController {

    @PutMapping("/enable")
    public String enable(@RequestBody Customer customerParam){
        return "OK";
    }

}

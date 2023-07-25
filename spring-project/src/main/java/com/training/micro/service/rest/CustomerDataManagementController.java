package com.training.micro.service.rest;

import com.training.micro.service.rest.models.Customer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/data/management")
public class CustomerDataManagementController {

    @PostMapping("/update")
    public String update(@RequestBody Customer customerParam){
        return "OK";
    }



}

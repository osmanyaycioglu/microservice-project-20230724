package com.training.micro.service.rest;

import com.training.micro.service.rest.models.CustomerRest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/data/management")
public class CustomerDataManagementController {

    @PostMapping("/update")
    public String update(@RequestBody CustomerRest customerParam){
        return "OK";
    }



}

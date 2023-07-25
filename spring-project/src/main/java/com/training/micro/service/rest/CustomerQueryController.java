package com.training.micro.service.rest;

import com.training.micro.service.rest.models.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer/query")
public class CustomerQueryController {

    @GetMapping("/by/customerId")
    public Customer findCustomer(@RequestParam("cid") Long customerId){
        return null;
    }


    @GetMapping("/all")
    public List<Customer> findAllCustomers(){
        return null;
    }

}

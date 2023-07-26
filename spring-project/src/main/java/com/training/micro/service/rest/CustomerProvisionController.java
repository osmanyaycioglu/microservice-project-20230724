package com.training.micro.service.rest;

import com.training.micro.service.rest.mappers.ICustomerMapper;
import com.training.micro.service.rest.models.CustomerRest;
import com.training.micro.service.services.CustomerProvisionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer/provision")
@Valid
@RequiredArgsConstructor
public class CustomerProvisionController {

    private final CustomerProvisionService customerProvisionService;

    @PostMapping("/add")
    public String add(@Valid @RequestBody CustomerRest customerParam) {
        customerProvisionService.addCustomer(ICustomerMapper.MAPPER.toCustomer(customerParam));
        return "OK";
    }

    @GetMapping("/suspend")
    public CustomerRest suspendCustomer(@NotNull @RequestParam("cid") Long customerId) {
        return null;
    }

    @PostMapping("/update")
    public String update(@RequestBody CustomerRest customerParam) {
        return "OK";
    }


}

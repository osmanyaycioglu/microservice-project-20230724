package com.training.micro.service.data;

import com.training.micro.service.data.daos.ICustomerDao;
import com.training.micro.service.services.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDataManager {

    private final ICustomerDao customerDao;

    public void insertCustomer(Customer customerParam){
        customerDao.save(customerParam);
    }

}

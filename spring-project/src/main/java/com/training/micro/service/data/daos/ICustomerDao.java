package com.training.micro.service.data.daos;

import com.training.micro.service.services.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerDao extends JpaRepository<Customer,Long> {
}

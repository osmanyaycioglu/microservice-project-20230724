package com.training.micro.service.rest.mappers;

import com.training.micro.service.rest.models.AddressRest;
import com.training.micro.service.rest.models.CustomerQuery;
import com.training.micro.service.rest.models.CustomerRest;
import com.training.micro.service.services.models.Address;
import com.training.micro.service.services.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ICustomerMapper {
    ICustomerMapper MAPPER = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerRest customer);

    CustomerQuery toCustomer(Customer customer);


    Address toAddress(AddressRest address);

    AddressRest toAddressRest(Address address);

    List<CustomerQuery> toCustomersQuery(List<Customer> customers);
}

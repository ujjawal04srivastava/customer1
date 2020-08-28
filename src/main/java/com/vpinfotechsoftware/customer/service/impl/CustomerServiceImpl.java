package com.vpinfotechsoftware.customer.service.impl;

import com.vpinfotechsoftware.customer.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService{


    @Override
    public Customer getCustomerById(UUID customerId) {
        return Customer.builder().id(UUID.randomUUID())
                .custName("Ujjawal Srivastava")
                .contactNumber(741570126)
                .emailId("ujjawal04sriastava@gmail.com")
                .build();
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        return Customer.builder().id(UUID.randomUUID())
        .custName("Sachin Tendulkar")
        .contactNumber(123456789)
        .emailId("st_sachin@gmail.com")
        .build();
    }

    @Override
    public void editCustomersDetail(Customer customer) {
        Customer.builder().emailId("ujjawal04srivastava@gmail.com").build();
    }

    @Override
    public void removeCustomer(UUID customerId) {
        log.info("Deletig Customer Record......");

    }


}

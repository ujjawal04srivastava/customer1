package com.vpinfotechsoftware.customer.service.impl;

import com.vpinfotechsoftware.customer.model.Customer;

import java.util.UUID;

public interface CustomerService {
    Customer getCustomerById(UUID customerId);

    Customer addNewCustomer(Customer customer);

    void editCustomersDetail(Customer customer);

    void removeCustomer(UUID customerId);
}

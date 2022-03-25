package com.saschakiefer.customer.services;

import com.saschakiefer.customer.CustomerRegistrationRequest;

public interface ICustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}

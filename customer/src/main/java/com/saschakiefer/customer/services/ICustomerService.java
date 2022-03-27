package com.saschakiefer.customer.services;

import com.saschakiefer.customer.controllers.CustomerRegistrationRequest;

public interface ICustomerService {
    void registerCustomer(CustomerRegistrationRequest request);
}

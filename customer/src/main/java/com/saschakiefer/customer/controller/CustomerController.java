package com.saschakiefer.customer.controller;

import com.saschakiefer.customer.CustomerRegistrationRequest;
import com.saschakiefer.customer.services.ICustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(CustomerController.PATH)
public class CustomerController {
    public static final String PATH = "/api/v1/customers";

    @Autowired
    ICustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRequest) {
        log.info("new customer registration {}", customerRequest);
        customerService.registerCustomer(customerRequest);
    }
}

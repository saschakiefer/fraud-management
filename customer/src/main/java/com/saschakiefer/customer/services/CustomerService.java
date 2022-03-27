package com.saschakiefer.customer.services;

import com.saschakiefer.customer.controllers.CustomerRegistrationRequest;
import com.saschakiefer.customer.models.Customer;
import com.saschakiefer.customer.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // TODO: Check valid email
        // TODO: Check unique eMail

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
    }
}

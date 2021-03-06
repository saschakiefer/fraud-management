package com.saschakiefer.customer.services;

import com.saschakiefer.amqp.RabbitMqMessageProducer;
import com.saschakiefer.clients.fraud.FraudCheckResponse;
import com.saschakiefer.clients.fraud.IFraudClient;
import com.saschakiefer.clients.notification.NotificationRequest;
import com.saschakiefer.customer.controllers.CustomerRegistrationRequest;
import com.saschakiefer.customer.models.Customer;
import com.saschakiefer.customer.repositories.ICustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService implements ICustomerService {

    private ICustomerRepository customerRepository;

//    private RestTemplate restTemplate;

    private IFraudClient fraudClient;
//    private INotificationClient notificationClient;

    private final RabbitMqMessageProducer rabbitMqMessageProducer;

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

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId());

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }

        NotificationRequest notificationRequest = new NotificationRequest(
                customer.getId(),
                customer.getEmail(),
                String.format("Hi %s, welcome to Kiefer Inc...", customer.getFirstName()));

//        notificationClient.sendNotification(notificationRequest);

        rabbitMqMessageProducer.publish(
                notificationRequest,
                "internal.exchange",
                "internal.notification.routing-key");
    }
}

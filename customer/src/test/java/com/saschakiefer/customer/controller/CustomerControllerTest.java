package com.saschakiefer.customer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saschakiefer.customer.CustomerRegistrationRequest;
import com.saschakiefer.customer.services.ICustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {CustomerController.class})
@ExtendWith(SpringExtension.class)
@EnableWebMvc
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    private ICustomerService customerService;

    @Test
    void registerCustomerBadRequest() throws Exception {
        mockMvc.perform(post(CustomerController.PATH))
                .andExpect(status().isBadRequest());
    }

    @Test
    void registerCustomerCreated() throws Exception {
        CustomerRegistrationRequest customer = new CustomerRegistrationRequest("John",
                "Doe", "john@doe.com");

        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(post(CustomerController.PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(customer)))
                .andExpect(status().isCreated());
    }
}
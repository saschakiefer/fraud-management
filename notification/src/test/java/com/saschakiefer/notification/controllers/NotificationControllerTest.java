package com.saschakiefer.notification.controllers;

import com.saschakiefer.notification.services.NotificationService;
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

@AutoConfigureMockMvc
@SpringBootTest(classes = {NotificationController.class})
@ExtendWith(SpringExtension.class)
@EnableWebMvc
class NotificationControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    NotificationService notificationService;

    @Test
    void SendNotification_NotificationRequest_SendsNotification() throws Exception {
        mockMvc.perform(post(NotificationController.PATH)
                        .content("{\"toCustomerId\":1,\"toCustomerName\":\"john@doe.com\",\"message\":\"You got a message\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
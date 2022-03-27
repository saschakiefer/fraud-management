package com.saschakiefer.fraud.controllers;

import com.saschakiefer.fraud.services.IFraudCheckService;
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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {FraudController.class})
@ExtendWith(SpringExtension.class)
@EnableWebMvc
class FraudControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private IFraudCheckService fraudCheckService;

    @Test
    void isFraudsterCheckReturnsFalse() throws Exception {
        when(fraudCheckService.isFraudulentCustomer(1)).thenReturn(false);

        mockMvc.perform(get(FraudController.PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"isFraudster\":false}"));
    }

    @Test
    void isFraudsterCheckReturnsTrue() throws Exception {
        when(fraudCheckService.isFraudulentCustomer(1)).thenReturn(true);

        mockMvc.perform(get(FraudController.PATH + "/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"isFraudster\":true}"));
    }
}
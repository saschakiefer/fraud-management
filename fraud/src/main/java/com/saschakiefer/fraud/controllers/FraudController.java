package com.saschakiefer.fraud.controllers;

import com.saschakiefer.fraud.services.IFraudCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(FraudController.PATH)
public class FraudController {
    public static final String PATH = "/api/v1/fraud-check";

    @Autowired
    private IFraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId) {
        log.info("checking customer id {}", customerId);
        boolean isFraudulantCustomer = fraudCheckService.isFraudulentCustomer(customerId);

        return new FraudCheckResponse(isFraudulantCustomer);
    }
}

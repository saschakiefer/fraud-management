package com.saschakiefer.fraud.services;

public interface IFraudCheckService {
    boolean isFraudulentCustomer(Integer customerId);
}

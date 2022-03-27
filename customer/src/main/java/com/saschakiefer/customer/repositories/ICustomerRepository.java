package com.saschakiefer.customer.repositories;

import com.saschakiefer.customer.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
}

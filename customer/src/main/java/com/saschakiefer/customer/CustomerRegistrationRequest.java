package com.saschakiefer.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

package com.saschakiefer.customer.controllers;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

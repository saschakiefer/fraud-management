package com.saschakiefer.customer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

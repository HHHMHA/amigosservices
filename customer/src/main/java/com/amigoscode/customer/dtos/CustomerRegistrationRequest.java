package com.amigoscode.customer.dtos;

import lombok.Data;

@Data
public class CustomerRegistrationRequest {
    String firstName;
    String lastName;
    String email;
}

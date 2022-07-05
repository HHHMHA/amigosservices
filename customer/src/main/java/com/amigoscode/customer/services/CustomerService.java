package com.amigoscode.customer.services;

import com.amigoscode.customer.dtos.CustomerRegistrationRequest;
import com.amigoscode.customer.models.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.getFirstName() )
                .lastName( request.getLastName() )
                .email( request.getEmail() )
                .build();
        // TODO: validation
        // TODO: store in db
    }
}

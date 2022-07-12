package com.amigoscode.customer.services;

import com.amigoscode.customer.dtos.CustomerRegistrationRequest;
import com.amigoscode.customer.models.Customer;
import com.amigoscode.customer.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService( CustomerRepository repository ) {
        this.repository = repository;
    }

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.getFirstName() )
                .lastName( request.getLastName() )
                .email( request.getEmail() )
                .build();
        // TODO: validation
        repository.save( customer );
    }
}

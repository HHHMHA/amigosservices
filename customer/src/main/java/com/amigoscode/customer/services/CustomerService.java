package com.amigoscode.customer.services;

import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.customer.dtos.CustomerRegistrationRequest;
import com.amigoscode.customer.models.Customer;
import com.amigoscode.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final FraudClient fraudClient;

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.getFirstName() )
                .lastName( request.getLastName() )
                .email( request.getEmail() )
                .build();
        // TODO: validation
        repository.saveAndFlush( customer );
        var response = fraudClient.isFraudster( customer.getId() );

        if ( response.isFraudster() ) {
            throw new IllegalStateException("fraudster");
        }
        // TODO: send notification
    }
}

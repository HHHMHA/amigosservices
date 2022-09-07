package com.amigoscode.customer.services;

import com.amigoscode.customer.dtos.CustomerRegistrationRequest;
import com.amigoscode.customer.dtos.FraudCheckResponse;
import com.amigoscode.customer.models.Customer;
import com.amigoscode.customer.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final RestTemplate restTemplate;

    public void registerCustomer( CustomerRegistrationRequest request ) {
        Customer customer = Customer.builder()
                .firstName( request.getFirstName() )
                .lastName( request.getLastName() )
                .email( request.getEmail() )
                .build();
        // TODO: validation
        repository.saveAndFlush( customer );
        var response = restTemplate.getForObject(
                "http://localhost:8081/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId()
        );

        if ( response.isFraudster() ) {
            throw new IllegalStateException("fraudster");
        }
        // TODO: send notification
    }
}

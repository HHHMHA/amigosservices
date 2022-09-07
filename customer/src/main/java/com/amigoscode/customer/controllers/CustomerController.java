package com.amigoscode.customer.controllers;

import com.amigoscode.customer.dtos.CustomerRegistrationRequest;
import com.amigoscode.customer.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping
    public void registerCustomer( @RequestBody CustomerRegistrationRequest customerRegistrationRequest ) {
        log.info( "new customer {}", customerRegistrationRequest );
        customerService.registerCustomer( customerRegistrationRequest );
    }
}

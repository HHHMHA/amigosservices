package com.amigoscode.fraud.controllers;

import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.fraud.services.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
public class FraudController {
    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster( @PathVariable Integer customerId ) {
        var isFraudulentCustomer = fraudCheckService.isFraudulentCustomer( customerId );
        return new FraudCheckResponse( isFraudulentCustomer );
    }
}

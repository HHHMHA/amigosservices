package com.amigoscode.fraud.services;

import com.amigoscode.fraud.models.FraudCheckHistory;
import com.amigoscode.fraud.repositories.FraudCheckHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    public boolean isFraudulentCustomer( Integer customerId ) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .isFraudster( false )
                        .customerId( customerId )
                        .createdAt( LocalDateTime.now() )
                        .build()
        );
        return false;
    }
}

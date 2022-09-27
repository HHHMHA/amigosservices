package com.amigoscode.clients.notification;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationRequest {
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String message;
}

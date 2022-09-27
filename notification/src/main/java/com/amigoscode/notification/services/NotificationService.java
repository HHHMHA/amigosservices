package com.amigoscode.notification.services;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.models.Notification;
import com.amigoscode.notification.repositories.NotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public void send( NotificationRequest notificationRequest ) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId( notificationRequest.getToCustomerId() )
                        .sender( "Amigoscode" )
                        .toCustomerEmail( notificationRequest.getToCustomerEmail() )
                        .message( notificationRequest.getMessage() )
                        .sentAt( LocalDateTime.now() )
                        .build()
        );
    }
}

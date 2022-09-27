package com.amigoscode.notification.controllers;

import com.amigoscode.clients.notification.NotificationRequest;
import com.amigoscode.notification.services.NotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
@AllArgsConstructor
@Slf4j
public class NotificationController {
    private final NotificationService notificationService;

    @PostMapping()
    public void sendNotification( @RequestBody NotificationRequest notificationRequest ) {
        log.info( "New notification {}", notificationRequest );
        notificationService.send( notificationRequest );
    }
}

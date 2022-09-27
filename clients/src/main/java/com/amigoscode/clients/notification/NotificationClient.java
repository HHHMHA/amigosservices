package com.amigoscode.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(
        value = "notification"
)
public interface NotificationClient {
    @GetMapping(path = "api/v1/notification")
    void sendNotification( NotificationRequest notificationRequest );
}

package com.saschakiefer.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notification", path = "api/v1/notifications")
public interface INotificationClient {

    @PostMapping
    void sendNotification(@RequestBody NotificationRequest notificationRequest);
}

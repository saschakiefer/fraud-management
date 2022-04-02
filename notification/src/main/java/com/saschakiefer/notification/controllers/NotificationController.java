package com.saschakiefer.notification.controllers;

import com.saschakiefer.clients.notification.NotificationRequest;
import com.saschakiefer.notification.services.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(NotificationController.PATH)
@AllArgsConstructor
public class NotificationController {
    public static final String PATH = "/api/v1/notifications";

    INotificationService notificationService;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("Notification created: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
    }
}

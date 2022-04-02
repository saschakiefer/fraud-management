package com.saschakiefer.notification.services;

import com.saschakiefer.clients.notification.NotificationRequest;

public interface INotificationService {
    void sendNotification(NotificationRequest notificationRequest);
}

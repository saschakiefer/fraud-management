package com.saschakiefer.notification.services;

import com.saschakiefer.clients.notification.NotificationRequest;
import com.saschakiefer.notification.models.Notification;
import com.saschakiefer.notification.repositories.INotificationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService implements INotificationService {

    private final INotificationRepository notificationRepository;

    @Override
    public void sendNotification(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Kiefer Inc.")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}

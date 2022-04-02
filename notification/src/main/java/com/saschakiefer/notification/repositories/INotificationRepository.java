package com.saschakiefer.notification.repositories;

import com.saschakiefer.notification.models.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INotificationRepository extends JpaRepository<Notification, Integer> {
}

package com.saschakiefer.notification.rabbitmq;

import com.saschakiefer.clients.notification.NotificationRequest;
import com.saschakiefer.notification.services.INotificationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class NotificationConsumer {

    private final INotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationRequest notificationRequest) {
        log.info("Consumed from Queue: {}", notificationRequest);
        notificationService.sendNotification(notificationRequest);
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

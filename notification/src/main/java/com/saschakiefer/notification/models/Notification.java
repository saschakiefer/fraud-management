package com.saschakiefer.notification.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id_sequence")
    @SequenceGenerator(name = "notification_id_sequence", sequenceName = "notification_id_sequence", allocationSize = 1)
    @Column(name = "notification_id", nullable = false)
    private Integer notificationId;

    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;
    private LocalDateTime sentAt;
}

package com.notification.notification_system.services;

import com.notification.notification_system.entity.Notification;
import com.notification.notification_system.kafka.KafkaProducerService;
import com.notification.notification_system.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final KafkaProducerService kafkaProducerService;

    public String sendNotification(String email, String message) {

        Notification notification = new Notification();
        notification.setEmail(email.trim());
        notification.setMessage(message.trim());
        notification.setCreatedAt(new Date());
        notification.setRead(false);

        notificationRepository.save(notification);

        // ✅ FIXED: Removed STR."..."
        kafkaProducerService.sendNotification(email + "|" + message);

        return "Notification Sent (Async via Kafka)";
    }

    public List<Notification> getUserNotifications(String email) {
        return notificationRepository.findByEmailOrderByCreatedAtDesc(email.trim());
    }

    public List<Notification> getUnreadNotifications(String email) {
        return notificationRepository.findByEmailAndIsReadFalse(email.trim());
    }

    public String markAsRead(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));

        notification.setRead(true);
        notificationRepository.save(notification);

        return "Marked as read";
    }
}
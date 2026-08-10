package com.notification.notification_system.kafka;

import com.notification.notification_system.services.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final EmailService emailService;

    @KafkaListener(topics = "notification-topic", groupId = "notification-group")
    public void consume(String message) {

        // message format: email|text
        String[] parts = message.split("\\|");

        String email = parts[0];
        String text = parts[1];

        emailService.sendEmail(email, text);

        System.out.println("📩 Email sent via Kafka to " + email);
    }
}
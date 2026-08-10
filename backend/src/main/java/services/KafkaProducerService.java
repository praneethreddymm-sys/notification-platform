package com.notification.notification_system.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "notification-topic";

    public void sendNotification(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
package com.notification.notification_system.services;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    public void sendEmail(String toEmail, String message) {

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(toEmail);
            mail.setSubject("New Notification 🔔");
            mail.setText(message);

            mailSender.send(mail);

            System.out.println("✅ Email sent successfully to " + toEmail);

        } catch (Exception e) {
            System.out.println("❌ Email failed: " + e.getMessage());
            throw new RuntimeException("Email sending failed");
        }
    }
}
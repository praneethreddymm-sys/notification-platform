package com.notification.notification_system.controller;

import com.notification.notification_system.dto.NotificationRequest;
import com.notification.notification_system.entity.Notification;
import com.notification.notification_system.services.NotificationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    // ✅ Send notification (secured)
    @PostMapping("/send")
    public String sendNotification(@Valid @RequestBody NotificationRequest request) {
        return notificationService.sendNotification(
                request.getEmail(),
                request.getMessage()
        );
    }

    // ✅ Get all notifications (JWT based)
    @GetMapping("/my")
    public List<Notification> getMyNotifications(Authentication auth) {
        String email = auth.getName();
        return notificationService.getUserNotifications(email);
    }

    // ✅ Get unread notifications
    @GetMapping("/unread")
    public List<Notification> getUnread(Authentication auth) {
        String email = auth.getName();
        return notificationService.getUnreadNotifications(email);
    }

    // ✅ Mark as read
    @PutMapping("/read/{id}")
    public String markAsRead(@PathVariable Long id) {
        return notificationService.markAsRead(id);
    }
}
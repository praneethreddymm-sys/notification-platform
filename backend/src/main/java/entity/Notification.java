package com.notification.notification_system.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private String email;

    private boolean isRead = false; // ✅ NEW FIELD

    private Date createdAt;
}
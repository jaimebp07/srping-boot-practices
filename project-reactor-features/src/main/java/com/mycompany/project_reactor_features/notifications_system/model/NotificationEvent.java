package com.mycompany.project_reactor_features.notifications_system.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {

    private String id;
    private String source;
    private String message;
    private Priority priority;
    private LocalDateTime timesTap;
    private NotificationStatus status;

}

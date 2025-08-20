package com.mycompany.project_reactor_features.notifications_system.service;

import com.mycompany.project_reactor_features.notifications_system.model.NotificationEvent;

import reactor.core.publisher.Mono;

public interface NotificationsService {

    public Mono<Boolean> sendNotification(NotificationEvent event);
    
}

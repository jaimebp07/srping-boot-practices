package com.mycompany.project_reactor_features.notifications_system.service;

import java.util.concurrent.ThreadLocalRandom;

import com.mycompany.project_reactor_features.notifications_system.model.NotificationEvent;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class PhoneService implements NotificationsService {

    @Override
    public Mono<Boolean> sendNotification(NotificationEvent event) {
        return Mono.fromCallable(() -> {

            Thread.sleep( 300);

            //simulate error with 10% probability
            if (ThreadLocalRandom.current().nextInt( 100) <= 20) {
                throw new RuntimeException("Error on send msg in Phone");
            }

            log.info("Msg in Phone OK: {}", event);

            return true;

        });
    }
}

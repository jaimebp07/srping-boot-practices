package com.mycompany.project_reactor_features;

import com.mycompany.project_reactor_features.notifications_system.service.EmailService;
import com.mycompany.project_reactor_features.notifications_system.service.NotificationsService;
import com.mycompany.project_reactor_features.notifications_system.service.PhoneService;
import com.mycompany.project_reactor_features.notifications_system.service.TeamsService;

import reactor.core.publisher.Mono;

import com.mycompany.project_reactor_features.notifications_system.NotificationSystem;
import com.mycompany.project_reactor_features.notifications_system.model.NotificationEvent;
import com.mycompany.project_reactor_features.notifications_system.model.NotificationStatus;
import com.mycompany.project_reactor_features.notifications_system.model.Priority;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

public class NotificationSystemTest {

    private NotificationsService mockTeamsService;
    private NotificationsService mockEmailService;
    private NotificationsService mockPhoneService;

    private NotificationSystem notificationSystem;

    private AtomicInteger TeamsNotificationCount;
    private AtomicInteger EmailNotificationCount;
    private AtomicInteger PhoneNotificationCount;

    @BeforeEach
    void setup(){
        this.TeamsNotificationCount = new AtomicInteger(0);
        this.EmailNotificationCount = new AtomicInteger(0);
        this.PhoneNotificationCount = new AtomicInteger(0);

        this.mockTeamsService = mock(TeamsService.class);
        this.mockEmailService = mock(EmailService.class);
        this.mockPhoneService = mock(PhoneService.class);

        when(this.mockTeamsService.sendNotification(any(NotificationEvent.class)))
        .thenAnswer(invocation -> {
            this.TeamsNotificationCount.incrementAndGet();
            return Mono.just(true);
        });

        when(this.mockEmailService.sendNotification(any(NotificationEvent.class)))
        .thenAnswer(invocation -> {
            this.EmailNotificationCount.incrementAndGet();
            return Mono.just(true);
        });

        when(this.mockPhoneService.sendNotification(any(NotificationEvent.class)))
        .thenAnswer(invocation -> {
            this.PhoneNotificationCount.incrementAndGet();
            return Mono.just(true);
        });

        this.notificationSystem = new NotificationSystem(
            mockTeamsService,
            mockEmailService,
            mockPhoneService
        );
    }

    @Test
    @DisplayName("Should send events with LOW priority") 
    void testLowPriority(){
        NotificationEvent event = createTestEvent(Priority.LOW);

        this.notificationSystem.publishEvent(event);

        this.sleep(500);

        verify(mockTeamsService, times(1)).sendNotification(any());
        verify(mockEmailService, never()).sendNotification(any());
        verify(mockPhoneService, never()).sendNotification(any());

        assert this.TeamsNotificationCount.get() == 1;
        assert this.EmailNotificationCount.get() == 0;
        assert this.PhoneNotificationCount.get() == 0;
    }

    private NotificationEvent createTestEvent(Priority priority) {
        return NotificationEvent.builder()
            .id(UUID.randomUUID().toString())
            .source("TEST")
            .message("Test msg with priority: " + priority.toString())
            .priority(priority)
            .timesTap(LocalDateTime.now())
            .status(NotificationStatus.PENDING)
            .build();
    }

    private void sleep(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
 
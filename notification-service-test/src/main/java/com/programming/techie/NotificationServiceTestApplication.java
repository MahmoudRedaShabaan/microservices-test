package com.programming.techie;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceTestApplication {

    private final ObservationRegistry observationRegistry;
    private final Tracer tracer;

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceTestApplication.class, args);
    }

//    @KafkaListener(topics = "notificationTopic")
//    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
//        Observation.createNotStarted("on-message", this.observationRegistry).observe(() -> {
//            log.info("Got message <{}>", orderPlacedEvent);
//            log.info("TraceId- {}, Received Notification for Order - {}", this.tracer.currentSpan().context().traceId(),
//                    orderPlacedEvent.getOrderNumber());
//        });
//        // send out an email notification
//    }

    @KafkaListener(topics = "test_topic",groupId = "group_id")
    public void handleNotification(OrderPlacedEvent orderPlacedEvent) {
            log.info("Received notification For Order - {}", orderPlacedEvent.getOrderNumber());

        // send out an email notification
    }
}

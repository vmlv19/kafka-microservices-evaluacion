package com.bank.producer.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotifyService {

    private static final String TOPIC = "topic-bank";

    private final KafkaTemplate<String, String> kafkaTemplate;

    public NotifyService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMsg(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Mensaje enviado a KAFKA: " + message);
    }
}

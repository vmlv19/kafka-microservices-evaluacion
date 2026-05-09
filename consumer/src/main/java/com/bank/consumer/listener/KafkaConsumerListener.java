package com.bank.consumer.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerListener {

    @KafkaListener(topics = "topic-bank", groupId = "bank-consumer-group")
    public void listen(ConsumerRecord<String, String> record){
        System.out.println("**********************************");
        System.out.println("    Mensaje recibido de KAFKA");
        System.out.println("    Tópico : " + record.topic());
        System.out.println("    Offset : " + record.offset());
        System.out.println("    Mensaje: " + record.value());
        System.out.println("**********************************");
    }
}
package com.nextuple.kafkametadata.consumer;

// Importing required classes
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

@Component

// Class
public class KafkaConsumer {

    @KafkaListener(topics = "quickstart-events", groupId = "group_id")
    public void consume(ConsumerRecord<String, String> consumerRecord, @Header("type") String header)
    {
        // Print statement
        System.out.println("message = " + consumerRecord.value());
        System.out.println("header = " + header);

    }
}
package com.nextuple.kafkametadata.procuder;

// Importing required classes
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController
// Class
public class ProducerController {

    // Autowiring Kafka Template
    @Autowired KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "quickstart-events";

    // Publish messages using the GetMapping
    @GetMapping("/publish/{message}")
    public String publishMessage(@PathVariable("message")
                                 final String message)
    {

        ProducerRecord<String, String> record = new ProducerRecord<String, String>(TOPIC,(Integer)null, "1", message);
        record.headers().add(new RecordHeader("type", "record_created".getBytes()));
        kafkaTemplate.send(record);

        // Sending the message
//        kafkaTemplate.send(TOPIC, message);

        return "Published Successfully";
    }
}
package com.rick.strproducer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMessage(String message) {
        System.out.println("Send message...");
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success -> {
//                    if (success != null) {
//                        System.out.println("Send message with success: " + message);
//                        System.out.println("Partition: " + success.getRecordMetadata().partition());
//                        System.out.println("OffSet: " + success.getRecordMetadata().offset());
//                        System.out.println("Topic: " + success.getProducerRecord().topic());
//                    }
//                },
//                error -> System.out.println("Send message with error: " + message)
//        );
    }
}

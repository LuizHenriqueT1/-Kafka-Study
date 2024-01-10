package com.rick.strconsumer.listeners;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class StrConsumerListerns {

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
            //podemos passa um array de partitions
                @TopicPartition(topic = "str-topic", partitions = {"0"})
            },
            topics = "str-topic", containerFactory = "strContainerFactory")
    public void create(String message) {
        System.out.println("CREATE ::: Receiver message: " + message);
    }

    @KafkaListener(groupId = "group-1",
            topicPartitions = {
                    @TopicPartition(topic = "str-topic", partitions = {"1"})
            },topics = "str-topic", containerFactory = "strContainerFactory")
    public void log(String message) {
        System.out.println("LOG ::: Receiver message: " + message);
    }

    @KafkaListener(groupId = "group-1", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        System.out.println("HISTORY ::: Receiver message: " + message);
    }
}

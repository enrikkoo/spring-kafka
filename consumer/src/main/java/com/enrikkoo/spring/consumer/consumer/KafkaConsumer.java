package com.enrikkoo.spring.consumer.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "thing1", groupId = "kafka-test")
    public void consume(final ConsumerRecord<String, String> consumerRecord) {
        System.out.println("Message received " + consumerRecord.value());
    }
}

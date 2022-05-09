package com.enrikkoo.spring.kafka.controller;

import com.enrikkoo.spring.kafka.dto.RequestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "v1")
public class MessageController {
    private final KafkaTemplate<String, RequestDto> kafkaTemplate;

    public MessageController(KafkaTemplate<String, RequestDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(path = "send")
    public void publish(@RequestBody RequestDto request) {
        kafkaTemplate.send(MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, request.getTopic())
                .setHeader(KafkaHeaders.MESSAGE_KEY, request.getUserId())
                .build());
    }
}

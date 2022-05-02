package com.enrikkoo.spring.kafka.controller;

import com.enrikkoo.spring.kafka.dto.RequestDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1")
public class MessageController {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping(path = "send")
    public void publish(@RequestBody RequestDto request){
        kafkaTemplate.send(request.getTopic(),request.getUserId(),request.getMessage());
    }
}

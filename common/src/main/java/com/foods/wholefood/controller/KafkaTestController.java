package com.foods.wholefood.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaTestController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(value = "testKafka")
    public String sendMessageToKafka() {
        kafkaTemplate.send("wf-topic", "dce");
        return "testKafka";
    }
}

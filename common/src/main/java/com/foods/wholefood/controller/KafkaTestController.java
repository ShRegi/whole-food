package com.foods.wholefood.controller;

import com.foods.wholefood.services.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    private final KafkaService kafkaService;

    @Autowired
    public KafkaTestController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @GetMapping(value = "testKafka")
    public String sendMessageToKafka() {
        kafkaService.sendMessage("wf-topic", "dce");
        return "message was sent";
    }

    @GetMapping(value = "stub")
    public String getQueueMassages() {
        return "stub";
    }
}

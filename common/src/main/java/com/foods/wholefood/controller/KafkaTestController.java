package com.foods.wholefood.controller;

import com.foods.wholefood.api.KafkaService;
import com.foods.wholefood.services.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    private final KafkaService kafkaMessageService;

    @Autowired
    public KafkaTestController(KafkaMessageService kafkaMessageService) {
        this.kafkaMessageService = kafkaMessageService;
    }

    @GetMapping(value = "testKafka")
    public String sendMessageToKafka() {
        kafkaMessageService.sendMessage("wf-topic", "dce");
        return "message was sent";
    }

    @GetMapping(value = "stub")
    public String getQueueMassages() {
        return "stub";
    }
}

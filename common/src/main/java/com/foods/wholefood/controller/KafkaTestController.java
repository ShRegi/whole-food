package com.foods.wholefood.controller;

import com.foods.wholefood.api.messaging.KafkaService;
import com.foods.wholefood.services.KafkaMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaTestController {

    public static final String TEST_KAFKA_URL = "/testKafka";
    public static final String STUB_URL = "/stub";
    public static final String STUB = "stub was returned";

    private final KafkaService kafkaMessageService;

    @Autowired
    public KafkaTestController(KafkaMessageService kafkaMessageService) {
        this.kafkaMessageService = kafkaMessageService;
    }

    @GetMapping(value = TEST_KAFKA_URL)
    public String sendMessageToKafka() {
        kafkaMessageService.sendMessage("wf-topic", "dce");
        return kafkaMessageService.isAnyMetricExist() ? "1" : "0";
    }

    @GetMapping(value = STUB_URL)
    public String getQueueMassages() {
        return STUB;
    }
}

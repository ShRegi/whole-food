package com.foods.wholefood.services;

import com.foods.wholefood.api.messaging.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageService implements KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }

    @Override
    public boolean isAnyMetricExist() {
        return kafkaTemplate.metrics().isEmpty();
    }
}

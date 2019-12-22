package com.foods.wholefood.services;

import com.foods.wholefood.api.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Profile("dev")
@Service
public class KafkaMessageService implements KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}

package com.foods.wholefood.services;

import com.foods.wholefood.api.KafkaService;
import com.foods.wholefood.configuration.ResourcesMockConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {ResourcesMockConfiguration.class})
class KafkaMessageServiceTest {

    @Autowired
    private  KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaService kafkaMessageService;

    @Test
    void testKafkaSendMessage() {
        kafkaMessageService.sendMessage("wf-topic", "dce");
        verify(kafkaTemplate, times(1)).send(anyString(), anyString());
    }
}
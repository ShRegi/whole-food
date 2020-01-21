package com.foods.wholefood.services;

import com.foods.wholefood.configuration.ResourcesMockConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {ResourcesMockConfiguration.class, KafkaMessageService.class})
class KafkaMessageServiceTest {

    private static final String TEST_TOPIC = "topic";
    private static final String TEST_MESSAGE = "message";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    private KafkaMessageService kafkaMessageService;

    @Test
    void testSendMessage() {
        kafkaMessageService.sendMessage(TEST_TOPIC, TEST_MESSAGE);
        verify(kafkaTemplate).send(eq(TEST_TOPIC), eq(TEST_MESSAGE));
    }

}
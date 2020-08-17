package com.foods.wholefood.configuration;

import org.springframework.context.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.mock;

@Configuration
public class ResourcesMockConfiguration {

    @Bean
    @Primary
    public KafkaTemplate<String, String> kafkaTemplate() {
        return mock(KafkaTemplate.class);
    }

}

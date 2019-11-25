package com.foods.wholefood.configuration;

import com.foods.wholefood.services.KafkaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class ServicesMockConfiguration {

    @Primary
    @Bean
    public KafkaService kafkaService() {
        return mock(KafkaService.class);
    }

}

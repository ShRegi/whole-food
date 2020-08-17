package com.foods.wholefood.configuration;

import com.foods.wholefood.api.KafkaService;
import com.foods.wholefood.services.KafkaMessageService;
import org.influxdb.InfluxDB;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;

import static org.mockito.Mockito.mock;

@Configuration
public class ResourcesMockConfiguration {

    @Primary
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return mock(KafkaTemplate.class);
    }

    @Bean
    public KafkaService kafkaService(KafkaTemplate<String, String> kafkaTemplate){
        return new KafkaMessageService(kafkaTemplate);
    }

    @Bean
    public InfluxDB influxDB(){
        return mock(InfluxDB.class);
    }
}

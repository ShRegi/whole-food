package com.foods.wholefood.configuration;

import com.foods.wholefood.configuration.properties.InfluxDBProperties;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(InfluxDBProperties.class)
public class DataSourceConfiguration {

    @Bean
    public InfluxDB influxDB(InfluxDBProperties properties) {
        return InfluxDBFactory.connect(properties.getUrl(), properties.getUsername(), properties.getPassword());
    }

}

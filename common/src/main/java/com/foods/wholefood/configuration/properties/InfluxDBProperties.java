package com.foods.wholefood.configuration.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ConfigurationProperties("spring.influxdb")
public class InfluxDBProperties {

    @NotEmpty
    private String url;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String database;

}

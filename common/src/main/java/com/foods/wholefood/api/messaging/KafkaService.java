package com.foods.wholefood.api.messaging;

public interface KafkaService {

    void sendMessage(String topic, String message);

    boolean isAnyMetricExist();

}

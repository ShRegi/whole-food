package com.foods.wholefood.api;

public interface KafkaService {

    void sendMessage(String topic, String message);

}

package com.foods.wholefood.utils;

import org.springframework.boot.SpringApplication;

import java.util.HashMap;
import java.util.Map;

import static com.foods.wholefood.WholeFoodsConstants.Environment.SPRING_PROFILE_DEVELOPMENT;
import static com.foods.wholefood.WholeFoodsConstants.SpringProperties.SPRING_PROFILE_DEFAULT;

public class PropertiesUtils {

    public static void addDefaultProfile(SpringApplication app) {
        Map<String, Object> defProperties = new HashMap<>();
        defProperties.put(SPRING_PROFILE_DEFAULT, SPRING_PROFILE_DEVELOPMENT);
        app.setDefaultProperties(defProperties);
    }
}

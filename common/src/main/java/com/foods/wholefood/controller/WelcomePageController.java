package com.foods.wholefood.controller;

import com.foods.wholefood.AppInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomePageController {

    private final Environment environment;

    @Autowired
    public WelcomePageController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/")
    public AppInfo welcome() {
        return AppInfo.builder().parameter("app-name", environment.getProperty("spring.application.name"))
                .build();
    }
}

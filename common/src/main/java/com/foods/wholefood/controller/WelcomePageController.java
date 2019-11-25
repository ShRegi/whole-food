package com.foods.wholefood.controller;

import com.foods.wholefood.AppInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomePageController {

    @GetMapping("/")
    public AppInfo welcome() {
        return AppInfo.builder().parameter("app-name", "APPPP")
                .build();
    }

    @GetMapping("err")
    public AppInfo getError() {
        return AppInfo.builder().parameter("ERROR", "Try to do it later").build();
    }
}

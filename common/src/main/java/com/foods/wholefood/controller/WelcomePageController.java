package com.foods.wholefood.controller;

import com.foods.wholefood.dto.AppInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomePageController {

    @GetMapping("/")
    public AppInfoDto welcome() {
        return AppInfoDto.builder().parameter("app-name", "APPPP")
                .build();
    }

    @GetMapping("err")
    public AppInfoDto getError() {
        return AppInfoDto.builder().parameter("ERROR", "Try to do it later").build();
    }
}

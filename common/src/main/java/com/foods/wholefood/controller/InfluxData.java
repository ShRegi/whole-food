package com.foods.wholefood.controller;

import com.foods.wholefood.repository.CurrencyHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxData {

    private final CurrencyHistoryRepository currencyHistoryRepository;

    @Autowired
    public InfluxData(CurrencyHistoryRepository currencyHistoryRepository) {
        this.currencyHistoryRepository = currencyHistoryRepository;
    }

    @GetMapping("/influxVersion")
    public String getInfluxUser() {
        return currencyHistoryRepository.getVersion();
    }
}

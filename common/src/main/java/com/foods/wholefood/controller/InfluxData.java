package com.foods.wholefood.controller;

import com.foods.wholefood.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfluxData {

    private final ReservationRepository reservationRepository;

    @Autowired
    public InfluxData(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/influxVersion")
    public String getInfluxUser() {
        return reservationRepository.getVersion();
    }
}

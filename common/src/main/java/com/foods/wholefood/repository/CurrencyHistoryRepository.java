package com.foods.wholefood.repository;

import org.influxdb.InfluxDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CurrencyHistoryRepository {

    private final InfluxDB influxDB;

    @Autowired
    public CurrencyHistoryRepository(InfluxDB influxDB) {
        this.influxDB = influxDB;
    }

    public String getVersion() {
        return influxDB.version();
    }

}

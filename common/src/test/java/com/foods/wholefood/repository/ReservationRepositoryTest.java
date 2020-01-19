package com.foods.wholefood.repository;

import com.foods.wholefood.configuration.ResourcesMockConfiguration;
import org.influxdb.InfluxDB;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.foods.wholefood.constant.TestConstants.INFLUSX_DB_TEST_VERSION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ResourcesMockConfiguration.class})
class ReservationRepositoryTest {

    @Autowired
    private InfluxDB influxDB;

    @Autowired
    private ReservationRepository reservationRepository;

    @Test
    void reservation_repository_test(){
        when(influxDB.version()).thenReturn(INFLUSX_DB_TEST_VERSION);
        String version = reservationRepository.getVersion();
        assertThat(version).isEqualTo(INFLUSX_DB_TEST_VERSION);
    }
}
package com.foods.wholefood;

import com.foods.wholefood.configuration.ServicesMockConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServicesMockConfiguration.class})
public class WholeFoodApplicationTests {

    @Test
    public void contextLoads() {
    }

}

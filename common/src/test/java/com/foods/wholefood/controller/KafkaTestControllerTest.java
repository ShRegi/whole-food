package com.foods.wholefood.controller;

import com.foods.wholefood.configuration.ServicesMockConfiguration;
import com.foods.wholefood.services.KafkaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ServicesMockConfiguration.class, KafkaTestController.class})
public class KafkaTestControllerTest {

    @Autowired
    public KafkaService kafkaService;
    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        doNothing().when(kafkaService).sendMessage(anyString(), anyString());
    }

    @Test
    public void testSendMessageToKafka() throws Exception {
        mockMvc.perform(get("/testKafka"))
                .andExpect(status().isOk())
                .andExpect(content().string("message was sent"));
        verify(kafkaService).sendMessage(eq("wf-topic"), eq("dce"));
    }
}

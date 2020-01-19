package com.foods.wholefood.controller;

import com.foods.wholefood.configuration.ServicesMockConfiguration;
import com.foods.wholefood.services.KafkaMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ServicesMockConfiguration.class, KafkaTestController.class})
public class KafkaTestControllerTest {

    @Autowired
    public KafkaMessageService kafkaMessageService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSendMessageToKafka() throws Exception {
        mockMvc.perform(get("/testKafka"))
                .andExpect(status().isOk())
                .andExpect(content().string("message was sent"));
        verify(kafkaMessageService).sendMessage(eq("wf-topic"), eq("dce"));
    }
}

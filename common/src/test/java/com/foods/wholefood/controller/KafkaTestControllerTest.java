package com.foods.wholefood.controller;

import com.foods.wholefood.configuration.ServicesMockConfiguration;
import com.foods.wholefood.constant.TestConstants;
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
        mockMvc.perform(get(TestConstants.URL_TEST_KAFKA))
                .andExpect(status().isOk())
                .andExpect(content().string(TestConstants.MESSAGE_WAS_SENT));
        verify(kafkaMessageService).sendMessage(eq(TestConstants.SEND_MESSAGE_WF_TOPIC),
                eq(TestConstants.SEND_MESSAGE_DCE));
    }
}

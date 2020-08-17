package com.foods.wholefood.controller;

import com.foods.wholefood.configuration.ServicesMockConfiguration;
import com.foods.wholefood.services.KafkaMessageService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import static com.foods.wholefood.controller.KafkaTestController.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = {ServicesMockConfiguration.class, KafkaTestController.class})
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class KafkaTestControllerTest {

    @Autowired
    public KafkaMessageService kafkaMessageService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSendMessageToKafkaMetricsExists() throws Exception {
        when(kafkaMessageService.isAnyMetricExist()).thenReturn(true);
        mockMvc.perform(get(TEST_KAFKA_URL))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
        verify(kafkaMessageService).isAnyMetricExist();
        verify(kafkaMessageService).sendMessage(eq("wf-topic"), eq("dce"));
    }

    @Test
    void testSendMessageToKafkaNoMetrics() throws Exception {
        when(kafkaMessageService.isAnyMetricExist()).thenReturn(false);
        mockMvc.perform(get(TEST_KAFKA_URL))
                .andExpect(status().isOk())
                .andExpect(content().string("0"));
        verify(kafkaMessageService).isAnyMetricExist();
        verify(kafkaMessageService).sendMessage(eq("wf-topic"), eq("dce"));
    }

    @Test
    void testStub() throws Exception {
        mockMvc.perform(get(STUB_URL))
                .andExpect(status().isOk())
                .andExpect(content().string(STUB));
        verify(kafkaMessageService, never()).sendMessage(eq("wf-topic"),eq("dce"));
    }
}

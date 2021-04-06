package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.EventHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EventHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllEventHistory() throws Exception {
        this.mockMvc.perform(get("/api/event_history"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("DESCR9")));
    }

    @Test
    void getEventHistoryById() throws Exception {
        this.mockMvc.perform(get("/api/event_history/1"))
                .andDo(print())
                .andExpect(status()
                        .isNotFound());
        this.mockMvc.perform(get("/api/event_history/9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("DESCR")));
    }
}
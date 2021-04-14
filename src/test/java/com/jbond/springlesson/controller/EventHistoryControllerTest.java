package com.jbond.springlesson.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.domain.EventType;
import com.jbond.springlesson.domain.Vehicle;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EventHistoryControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private EventHistoryRepository eventHistoryRepository;
    @Autowired
    private EventTypeRepository eventTypeRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void getAllEventHistory() throws Exception {
        mockMvc.perform(get("/event_histories"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("DESCR9")));
    }

    @Test
    public void getEventHistoryById() throws Exception {
        mockMvc.perform(get("/event_histories/1"))
                .andDo(print())
                .andExpect(status()
                        .isNotFound());
        mockMvc.perform(get("/event_histories/9"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .string(containsString("DESCR")));
    }

    @Test
    public void updateEventHistoryById() throws Exception {
        Vehicle vehicle = new Vehicle("VehicleUpdate");
        vehicleRepository.save(vehicle);
        EventType eventType = new EventType("eventTypeUpdated");
        eventTypeRepository.save(eventType);

        EventHistory eventHistory = new EventHistory(3L, LocalDateTime.now().minusMinutes(20), LocalDateTime.now(), "UPDATE_TEST", vehicle, eventType);

        this.mockMvc.perform((put("/event_histories")
                .content(objectMapper.writeValueAsString(eventHistory))
                .contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.eventDescription").value("UPDATE_TEST"));
    }

    @Test
    public void deleteEventHistoryById() throws Exception {
        mockMvc.perform(delete("/event_histories/6"))
                .andExpect(status().isOk());
    }

}
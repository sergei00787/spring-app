package com.jbond.springlesson.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class EventHistoryTest {
    @Test
    public void testConstructor() {
        EventHistory eventHistory = new EventHistory(LocalDateTime.now(), LocalDateTime.now(), "descr1", new Vehicle("111"), new EventType("EV_TYPE1"));
        assertEquals(1, eventHistory.getId());
    }

}
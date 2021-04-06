package com.jbond.springlesson.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTypeTest {
    @Test
    public void testConstructor() {
        EventType eventType = new EventType("eventtype");
        assertEquals("eventtype", eventType.getName());
    }
}
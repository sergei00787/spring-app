package com.jbond.springlesson.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EventHistoryTest {
    @Test
    public void testConstructor() {
        List<Property> propertyList= new ArrayList<>();
        Property prop = new Property("PropTest","String");
        propertyList.add(prop);

        EventHistory eventHistory = new EventHistory(LocalDateTime.now(), LocalDateTime.now(), "descr1", new Vehicle("111", propertyList), new EventType("EV_TYPE1"));
        assertEquals(1, eventHistory.getId());
    }

}
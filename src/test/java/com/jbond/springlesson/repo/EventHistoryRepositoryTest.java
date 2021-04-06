package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.domain.EventType;
import com.jbond.springlesson.domain.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class EventHistoryRepositoryTest {

    @Autowired
    private EventHistoryRepository eventHistoryRepository;

    @Test
    public void testFindEvenHistory(){
//        Vehicle vehicle = new Vehicle("1");
//        EventType eventType = new EventType("ET1");
//        LocalDateTime nowTime = LocalDateTime.now();
//        EventHistory eventHistory = new EventHistory(99L, nowTime, nowTime, "Descr", vehicle, eventType);
//        eventHistoryRepository.save(eventHistory);
//        EventHistory eventHistory2 = eventHistoryRepository.findEventHistoriesByEventDescription("Descr");

//        assertNotNull(eventHistoryRepository);
//        assertEquals(eventHistory2.getEventDescription(), eventHistory.getEventDescription());
//        assertEquals(eventHistory2.getVehicle(), eventHistory.getVehicle());
    }
}
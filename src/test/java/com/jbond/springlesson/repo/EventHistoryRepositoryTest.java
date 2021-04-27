package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.domain.EventType;
import com.jbond.springlesson.domain.Property;
import com.jbond.springlesson.domain.Vehicle;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class EventHistoryRepositoryTest {

    @Autowired
    private EventHistoryRepository eventHistoryRepository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Test
    public void testFindEvenHistory(){

        LocalDateTime nowTime = LocalDateTime.now();

        List<Property> propertyList= new ArrayList<>();
        Property prop = new Property("PropTest","String");
        propertyList.add(prop);

        Vehicle vehicle = new Vehicle("vvv1", propertyList);
        vehicleRepository.save(vehicle);
        Vehicle vehicle1 = vehicleRepository.findVehicleByVehName("vvv1");
        assertEquals(vehicle.getId(), vehicle1.getId());

        EventType eventType = new EventType("ET1");
        eventTypeRepository.save(eventType);
        EventType eventType1 = eventTypeRepository.findEventTypeByName("ET1");
        assertEquals(eventType.getId(), eventType1.getId());

        EventHistory eventHistory = new EventHistory(100L, nowTime, nowTime, "Ddd", vehicle,  eventType);
        System.out.println(eventHistory);

        eventHistoryRepository.save(eventHistory);

        EventHistory eventHistory2 = eventHistoryRepository.findEventHistoriesByEventDescription("Ddd");

        assertNotNull(eventHistoryRepository);
        assertEquals(eventHistory2.getEventDescription(), eventHistory.getEventDescription());
        assertEquals(eventHistory2.getVehicle(), eventHistory.getVehicle());
    }
}
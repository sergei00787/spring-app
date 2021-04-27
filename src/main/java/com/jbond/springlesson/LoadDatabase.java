package com.jbond.springlesson;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.domain.EventType;
import com.jbond.springlesson.domain.Property;
import com.jbond.springlesson.domain.Vehicle;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.PropertyRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(VehicleRepository vehicleRepository,
                                   EventTypeRepository eventTypeRepository,
                                   EventHistoryRepository eventHistoryRepository,
                                   PropertyRepository propertiesRepository) {
        return args -> {
            ArrayList<Property> propertyList = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                Property property = new Property("PropName"+i, "propType"+i);
                propertyList.add(property);
                propertiesRepository.save(property);

                Vehicle vehicle = new Vehicle( "Vehicle"+i, propertyList);
//                log.info("Preloading " + vehicleRepository.save(vehicle));
                vehicleRepository.save(vehicle);

                EventType eventType = new EventType("eventType"+i);
//                log.info("Preloading " + eventTypeRepository.save(eventType));
                eventTypeRepository.save(eventType);

                EventHistory eventHistory = new EventHistory(LocalDateTime.now().minusMinutes(20), LocalDateTime.now(),"DESCR"+i, vehicle, eventType);
//                log.info("Preloading " + eventHistoryRepository.save(eventHistory));
                eventHistoryRepository.save(eventHistory);
            }
        };
    }

}

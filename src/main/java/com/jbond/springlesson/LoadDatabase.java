package com.jbond.springlesson;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.domain.EventType;
import com.jbond.springlesson.domain.Vehicle;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(VehicleRepository vehicleRepository, EventTypeRepository eventTypeRepository, EventHistoryRepository eventHistoryRepository) {
        return args -> {
            Vehicle vehicle1 = new Vehicle("1");
            Vehicle vehicle2 = new Vehicle("2");
            Vehicle vehicle3 = new Vehicle("3");
            Vehicle vehicle4 = new Vehicle("4");
            log.info("Preloading " + vehicleRepository.save(vehicle1));
            log.info("Preloading " + vehicleRepository.save(vehicle2));
            log.info("Preloading " + vehicleRepository.save(vehicle3));
            log.info("Preloading " + vehicleRepository.save(vehicle4));

            EventType eventType1 = new EventType("eventType1");
            EventType eventType2 = new EventType("eventType2");
            EventType eventType3 = new EventType("eventType3");
            EventType eventType4 = new EventType("eventType4");

            log.info("Preloading " + eventTypeRepository.save(eventType1));
            log.info("Preloading " + eventTypeRepository.save(eventType2));
            log.info("Preloading " + eventTypeRepository.save(eventType3));
            log.info("Preloading " + eventTypeRepository.save(eventType4));

            EventHistory eventHistory1 = new EventHistory(1, LocalDateTime.now().minusMinutes(20), LocalDateTime.now(),"DESCR1", vehicle1, eventType1);
            EventHistory eventHistory2 = new EventHistory(1, LocalDateTime.now().minusMinutes(20), LocalDateTime.now(),"DESCR2", vehicle2, eventType2);
            EventHistory eventHistory3 = new EventHistory(1, LocalDateTime.now().minusMinutes(20), LocalDateTime.now(),"DESCR3", vehicle3, eventType3);

            log.info("Preloading " + eventHistoryRepository.save(eventHistory1));
            log.info("Preloading " + eventHistoryRepository.save(eventHistory2));
            log.info("Preloading " + eventHistoryRepository.save(eventHistory3));

//            log.info("Preloading " + eventHistoryRepository.save(new EventHistory(1, LocalDateTime.now(), LocalDateTime.now(),"DESCR1", new Vehicle("5"), new EventType( "Sttpg"))));

        };
    }

}

package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.exception.NotFoundException;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Optional;

@RestController
public class EventHistoryController {
    private EventHistoryRepository eventHistoryRepository;
    private EventTypeRepository eventTypeRepository;
    private VehicleRepository vehicleRepository;

    public EventHistoryController(EventHistoryRepository eventHistoryRepository, EventTypeRepository eventTypeRepository, VehicleRepository vehicleRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping(path = "/event_histories", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<EventHistory> getAllEventHistory() throws NotFoundException {
        Collection<EventHistory> optionalEventHistory = (Collection<EventHistory>) eventHistoryRepository.findAll();
        if (optionalEventHistory.isEmpty()) throw new NotFoundException("Event History not found");
        return optionalEventHistory;
    }


    @GetMapping(path = "/event_histories/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EventHistory getEventHistoryById(
            @PathVariable("id") Long id) throws NotFoundException {
        Optional<EventHistory> optEventHistory = eventHistoryRepository.findById(id);
        if (optEventHistory.isPresent()) {
            return optEventHistory.get();
        }
        throw new NotFoundException("Event History with ID=" + id + " not found");
    }

    @PostMapping(path = "/event_histories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EventHistory postEventHistory(@RequestBody EventHistory eventHistory) {
        return eventHistoryRepository.save(eventHistory);
    }

    @PutMapping(path = "/event_histories",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EventHistory updateEventHistory(@RequestBody EventHistory eh) {
        EventHistory eventHistory = eventHistoryRepository.findById(eh.getId()).get();

        eventHistory.setTime(eh.getTime());
        eventHistory.setTimeCreate(eh.getTimeCreate());
        eventHistory.setEventDescription(eh.getEventDescription());
        eventHistory.setVehicle(eh.getVehicle());
        eventHistory.setEventType(eh.getEventType());
        return eventHistoryRepository.save(eventHistory);
    }

    @DeleteMapping(path = "event_histories/{id}")
    public ResponseEntity<String> deleteHistory(@PathVariable("id") Long id){
        eventHistoryRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}

package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/event_history", produces = "application/json")
public class EventHistoryController {
    private EventHistoryRepository eventHistoryRepository;
    private EventTypeRepository eventTypeRepository;
    private VehicleRepository vehicleRepository;

    public EventHistoryController(EventHistoryRepository eventHistoryRepository, EventTypeRepository eventTypeRepository, VehicleRepository vehicleRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @GetMapping()
    public Collection<EventHistory> getAllEventHistory(){
        Collection<EventHistory> optionalEventHistory = (Collection<EventHistory>) eventHistoryRepository.findAll();
        if (optionalEventHistory.isEmpty()) return null;
        return optionalEventHistory;
    }

    @GetMapping("/{id}")
    public EventHistory getEventHistoryById(@PathVariable("id") Long id){
        Optional<EventHistory> optEventHistory = eventHistoryRepository.findById(id);
        if (optEventHistory.isPresent()) {
            return optEventHistory.get();
        }
        return null;
    }



}

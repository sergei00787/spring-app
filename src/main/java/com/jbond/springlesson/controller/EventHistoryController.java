package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.exception.NotFoundException;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public Collection<EventHistory> getAllEventHistory() throws NotFoundException {
        Collection<EventHistory> optionalEventHistory = (Collection<EventHistory>) eventHistoryRepository.findAll();
        if (optionalEventHistory.isEmpty()) throw new NotFoundException("Event History not found");;
        return optionalEventHistory;
    }


    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public EventHistory getEventHistoryById(@PathVariable("id") Long id) throws NotFoundException {
        Optional<EventHistory> optEventHistory = eventHistoryRepository.findById(id);
        if (optEventHistory.isPresent()) {
            return optEventHistory.get();
        }
        throw new NotFoundException("Event History with ID=" + id + " not found");
    }


}

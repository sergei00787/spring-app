package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.Property;
import com.jbond.springlesson.exception.NotFoundException;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.PropertyRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class PropertiesController {
    private EventHistoryRepository eventHistoryRepository;
    private EventTypeRepository eventTypeRepository;
    private VehicleRepository vehicleRepository;
    private PropertyRepository propertiesRepository;

    public PropertiesController(EventHistoryRepository eventHistoryRepository, EventTypeRepository eventTypeRepository, VehicleRepository vehicleRepository, PropertyRepository propertiesRepository) {
        this.eventHistoryRepository = eventHistoryRepository;
        this.eventTypeRepository = eventTypeRepository;
        this.vehicleRepository = vehicleRepository;
        this.propertiesRepository = propertiesRepository;
    }

    @GetMapping(path = "/properties", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Property> getAllEventHistory() throws NotFoundException {
        Collection<Property> optionalProperties = (Collection<Property>) propertiesRepository.findAll();
        if (optionalProperties.isEmpty()) throw new NotFoundException("Event History not found");
        return optionalProperties;
    }
}

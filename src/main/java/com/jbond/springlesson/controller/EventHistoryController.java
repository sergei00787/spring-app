package com.jbond.springlesson.controller;

import com.jbond.springlesson.domain.EventHistory;
import com.jbond.springlesson.exception.NotFoundException;
import com.jbond.springlesson.repo.EventHistoryRepository;
import com.jbond.springlesson.repo.EventTypeRepository;
import com.jbond.springlesson.repo.VehicleRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.swing.text.html.Option;
import java.util.Collection;
import java.util.Objects;
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
        if (optionalEventHistory.isEmpty()) throw new NotFoundException("Event History not found");
        ;
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

    //    {
//        "id": 999,
//        "time": "08.01.2020T08:00:00",
//        "timeCreate": "08.01.2020T08:00:00",
//        "eventDescription": "BlaBalBla",
//        "vehicle": {
//          "id": 1
//          },
//        "eventType": {
//          "id": 2
//          }
//    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public EventHistory postEventHistory(@RequestBody EventHistory eventHistory) {
        return eventHistoryRepository.save(eventHistory);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public EventHistory updateEventHistory(@RequestBody EventHistory eventHistory) {
        EventHistory evHist = eventHistoryRepository.findById(eventHistory.getId()).get();
//        Objects. .isNull(evHist) throw new NotFoundException("EventHistory not found);
        evHist.setTime(eventHistory.getTime());
        evHist.setTimeCreate(eventHistory.getTimeCreate());
        return eventHistoryRepository.save(evHist);
    }


}

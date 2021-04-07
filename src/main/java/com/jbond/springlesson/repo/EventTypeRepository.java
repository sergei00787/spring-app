package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.EventType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "eventType", path = "event_type")
public interface EventTypeRepository extends CrudRepository<EventType, Long> {
    List<EventType> findByName(@Param("name") String name);
    EventType findById(@Param("id") long id);
    EventType findEventTypeByName(@Param("name") String name);
}

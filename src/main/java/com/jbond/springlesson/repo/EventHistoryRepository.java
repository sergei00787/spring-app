package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.EventHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "event_history", path = "event_history")
@Repository
public interface EventHistoryRepository extends CrudRepository<EventHistory, Long> {
    EventHistory findEventHistoriesByEventDescription(String description);
}

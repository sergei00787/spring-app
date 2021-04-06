package com.jbond.springlesson.repo;

import com.jbond.springlesson.domain.EventHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "event_history", path = "event_history")
public interface EventHistoryRepository extends PagingAndSortingRepository<EventHistory, Long> {
}

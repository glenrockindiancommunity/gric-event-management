package org.glenrockindiancommunity.repository;

import org.glenrockindiancommunity.model.GricEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;

@RepositoryRestResource(path = "/event", collectionResourceRel = "events")
public interface EventRepository extends PagingAndSortingRepository<GricEvent, String> {

  GricEvent findByName(String name);

  List<GricEvent> findByEndDateTimeGreaterThanEqual(LocalDateTime today);

}

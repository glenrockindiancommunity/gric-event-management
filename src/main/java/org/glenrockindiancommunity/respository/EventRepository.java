package org.glenrockindiancommunity.respository;

import java.util.List;

import org.glenrockindiancommunity.model.GricEvent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends PagingAndSortingRepository<GricEvent, String> {

  GricEvent findByName(String name);

  public Page<GricEvent> findAll(Pageable pageable);

  public List<GricEvent> findAll();

}

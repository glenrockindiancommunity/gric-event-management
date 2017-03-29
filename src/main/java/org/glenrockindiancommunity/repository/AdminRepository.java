package org.glenrockindiancommunity.repository;

import org.glenrockindiancommunity.model.security.Admin;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AdminRepository extends PagingAndSortingRepository<Admin, String> {

}

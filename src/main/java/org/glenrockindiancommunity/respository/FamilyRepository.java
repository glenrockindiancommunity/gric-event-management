package org.glenrockindiancommunity.respository;

import org.glenrockindiancommunity.model.Family;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "family")
public interface FamilyRepository extends PagingAndSortingRepository<Family, String> {

  /**
   * familyNameCode is a unique generated id, which each registered family will
   * get. Use this for reference if they want to pull up the registration.
   * 
   * @param familyNameCode
   * @return
   */
  Family findByFamilyNameCode(String familyNameCode);

}

package org.glenrockindiancommunity.respository;

import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FamilyRepository extends PagingAndSortingRepository<Family, String> {

  /**
   * familyNameCode is a unique generated id, which each registered family will
   * get. Use this for reference if they want to pull up the registration.
   * 
   * @param familyNameCode
   * @return
   */
  Family findByFamilyNameCode(String familyNameCode);

  public Page<Family> findAll(Pageable pageable);

  public List<Family> findAll();

}

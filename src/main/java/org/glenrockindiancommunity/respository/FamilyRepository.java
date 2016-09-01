package org.glenrockindiancommunity.respository;

import org.glenrockindiancommunity.model.Family;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.socialsignin.spring.data.dynamodb.repository.EnableScanCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FamilyRepository extends PagingAndSortingRepository<Family, String> {

	/**
	 * familyNameCode is a unique generated id, which each registered family
	 * will get. Use this for reference if they want to pull up the
	 * registration.
	 * 
	 * @param familyNameCode
	 * @return
	 */
	@EnableScan
	Family findByFamilyNameCode(String familyNameCode);

	@EnableScan
	@EnableScanCount
	public Page<Family> findAll(Pageable pageable);

}

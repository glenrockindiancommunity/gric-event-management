package org.glenrockindiancommunity.repository;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class FamilyRepositoryTest {

  @Autowired
  private FamilyRepository repository;

  @Test
  public void registerFamilyTest() {
    Family family = new Family("Lastname", "firstname", "GR", 2, 2, "test@example.com", true, true);
    String familyNameCode = family.getFamilyNameCode();
    repository.save(family);

    Family family2 = new Family("Lastname_2", "firstname_2", "GR", 4, 0, "test@example.com", true, false);
    repository.save(family2);

    Family family3 = repository.findByFamilyNameCode(familyNameCode);

    Assert.assertEquals(family3, family);
  }

}

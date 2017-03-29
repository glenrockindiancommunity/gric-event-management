package org.glenrockindiancommunity.repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.model.GricEvent;
import org.glenrockindiancommunity.respository.AdminRepository;
import org.glenrockindiancommunity.respository.EventRepository;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class AllRepositoryTest {

  @Autowired
  private FamilyRepository familyRepository;
  @Autowired
  private EventRepository eventRepository;
  @Autowired
  private AdminRepository adminRepository;

  @Test
  public void registerFamilyTest() {
    Family family = new Family("Lastname", "firstname", "GR", 2, 2, "test@example.com", true, true);
    String familyNameCode = family.getFamilyNameCode();
    familyRepository.save(family);

    Family family2 = new Family("Lastname_2", "firstname_2", "GR", 4, 0, "test@example.com", true, false);
    familyRepository.save(family2);

    Family family3 = familyRepository.findByFamilyNameCode(familyNameCode);

    Assert.assertEquals(family3, family);
  }

  @Test
  public void testEventGreaterThan() {
    GricEvent event = new GricEvent("Holi Event", LocalDateTime.now().plusDays(5),
        LocalDateTime.now().plusDays(5).plusHours(4), "Saddle River County Pary", new BigDecimal("10.00"),
        new BigDecimal("5.0"), false);

    eventRepository.save(event);

    List<GricEvent> nowEvent = eventRepository.findByEndDateTimeGreaterThanEqual(LocalDateTime.now());

    Assert.assertEquals(nowEvent.get(0).getId(), event.getId());
  }

  @Test
  public void testEventNoneGreaterThan() {
    GricEvent event = new GricEvent("Holi Event", LocalDateTime.now().minusDays(5),
        LocalDateTime.now().minusDays(5).plusHours(4), "Saddle River County Pary", new BigDecimal("10.00"),
        new BigDecimal("5.0"), false);

    eventRepository.save(event);

    List<GricEvent> nowEvent = eventRepository.findByEndDateTimeGreaterThanEqual(LocalDateTime.now());

    Assert.assertEquals(nowEvent.size(), 0);

  }
  
  @Test
  public void testGetEvent() {
    GricEvent event = new GricEvent("Holi Event", LocalDateTime.now().minusDays(5),
        LocalDateTime.now().minusDays(5).plusHours(4), "Saddle River County Pary", new BigDecimal("10.00"),
        new BigDecimal("5.0"), false);

    eventRepository.save(event);

    GricEvent dbEvent = eventRepository.findOne(event.getId());
    Assert.assertEquals(event.getName(), dbEvent.getName());
  }



}

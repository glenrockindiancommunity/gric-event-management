package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class DoEverythingTest {

  @Autowired
  private DoEverything doEverything;

  @Test
  public void testCalculateTotalChargeWithGR() {
    String townCode = "GR";
    int adultCount = 2;
    int childCount = 1;

    BigDecimal expectedTotalCharge = new BigDecimal("103.30");

    BigDecimal totalCharge = doEverything.calculateTotalCharge(townCode, adultCount, childCount);
    System.out.println(totalCharge);

    Assert.assertEquals(expectedTotalCharge, totalCharge);
  }

  @Test
  public void testCalculateTotalChargeWithNonGR() {
    String townCode = "Other";
    int adultCount = 2;
    int childCount = 1;

    BigDecimal expectedTotalCharge = new BigDecimal("113.60");

    BigDecimal totalCharge = doEverything.calculateTotalCharge(townCode, adultCount, childCount);
    System.out.println(totalCharge);

    Assert.assertEquals(expectedTotalCharge, totalCharge);
  }

}

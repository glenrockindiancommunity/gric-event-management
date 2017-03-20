package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EventRegistrationService {

  private static final Logger log = LoggerFactory.getLogger(EventRegistrationService.class);

  // === Pricing Variables ===

  // 30¢ per successful charge
  private BigDecimal stripeFixedFee = new BigDecimal(0.3);
  // standard US pricing of 2.9%
  private BigDecimal stripeTransactionPercent = new BigDecimal(0.029);

  private BigDecimal adultCost = new BigDecimal(40);
  private BigDecimal childCost = new BigDecimal(20);
  private BigDecimal nonGRMarkup = new BigDecimal(0.1);

  @Autowired
  private Talk2Stripe talk2Stripe;

  @Autowired
  private FamilyRepository repository;
  
  

  /**
   * read method name
   * 
   * @param family
   */
  public Family acceptPaymentAndRegisterFamily(Family family) {

    log.info("Accepting payment for family " + family.toString());

    try {

      BigDecimal recalculatedAmount = calculateTotalCharge(family.getTown(), family.getAdults(), family.getChildren());

      family.setAmount(recalculatedAmount);

      // once the
      log.info("Calling Stripe to charge...");

      // reset it, as token id is just a temporary variable for it.
      family.setStripeReceiptNumber(
          talk2Stripe.createCharge(family.getPrimaryEmail(), family.getAmount(), family.getStripeReceiptNumber()));

      log.info("Saving family info to DB...");
      // Now that payment was successful, now save everything to database.
      repository.save(family);

    } catch (Exception e) {
      throw new RuntimeException(
          e.getMessage() + "There was an error processing your payment. Please get in touch with the organizers");
    }

    return family;
  }

  /**
   * Calculates the final fee for the event.
   * 
   * @param townCode
   * @param adultCount
   * @param childCount
   * @return
   */
  public BigDecimal calculateTotalCharge(String townCode, int adultCount, int childCount) {
    log.info(
        "calculating total for; townCode: " + townCode + ", adultCount:" + adultCount + " , childCount:" + childCount);

    // in cents.
    BigDecimal adultCharge = adultCost.multiply(new BigDecimal(adultCount));
    BigDecimal childCharge = childCost.multiply(new BigDecimal(childCount));

    BigDecimal totalCharge = adultCharge.add(childCharge);

    log.info("Base total charge for GR in cents : " + totalCharge);

    if (!"GR".equalsIgnoreCase(townCode)) {
      totalCharge = totalCharge.add(totalCharge.multiply(nonGRMarkup));
      log.info("Base total charge if not from GR: " + totalCharge);
    }

    totalCharge = addStripeFeeToTotal(totalCharge);

    log.info("Final Total after Stripe Charge: " + totalCharge);

    return totalCharge;
  }

  /**
   * Stripe charges a fee of 2.9% for every transaction and a 30¢ fee per
   * successful transaction. We are offloading the fee to our consumers. This
   * method uses the math to verify the pricing we should be finally charging.
   * 
   * 
   * pCharge = (pGoal + fFixed) / (1 - fPercent); <br/>
   * pGoal = Actual Price <br/>
   * fFixed = Fixed fee (30¢ per successful charge) <br/>
   * fPercent = Standard transfer fee of 2.9% <br/>
   * pCharge = final amount to charge <br/>
   * 
   * @param pGoal
   *          - target value to charge
   * @return
   */
  private BigDecimal addStripeFeeToTotal(BigDecimal pGoal) {
    BigDecimal fFixed = stripeFixedFee;
    BigDecimal fPercent = stripeTransactionPercent;

    BigDecimal pCharge = pGoal.add(fFixed);
    fPercent = new BigDecimal(1).subtract(fPercent);
    pCharge = pCharge.divide(fPercent, 2, BigDecimal.ROUND_CEILING);

    return pCharge;
  }

  public List<Family> showAll() {
    return repository.findAll();
  }

}

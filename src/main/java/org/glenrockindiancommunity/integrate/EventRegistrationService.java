package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.model.GricEvent;
import org.glenrockindiancommunity.respository.EventRepository;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EventRegistrationService {

  private static final Logger log = LoggerFactory.getLogger(EventRegistrationService.class);

  // === Pricing Variables ===

  // standard US pricing of 2.9%
  private BigDecimal stripeTransactionPercent = new BigDecimal(0.029);
  // 30¢ per successful charge
  private BigDecimal stripeFixedFee = new BigDecimal(0.3);

  @Autowired
  private Talk2Stripe talk2Stripe;
  @Autowired
  private FamilyRepository familyRepo;
  @Autowired
  private EventRepository eventRepo;

  /**
   * read method name
   * 
   * @param family
   */
  @Transactional
  public Family acceptPaymentAndRegisterFamily(String eventId, Family family) {
    log.info("Accepting payment for family " + family.toString());

    try {
      GricEvent event = eventRepo.findOne(eventId);

      // If an event is marked free, you'll not be charging anything.
      if (!event.isFree()) {
        BigDecimal recalculatedAmount = calculateTotalCharge(event, family.getAdults(), family.getChildren());
        family.setAmount(recalculatedAmount);

        // once the price is calculated, call stripe
        log.info("Calling Stripe to charge...");

        // reset it, as token id is just a temporary variable for it.
        family.setStripeReceiptNumber(
            talk2Stripe.createCharge(family.getPrimaryEmail(), family.getAmount(), family.getStripeReceiptNumber()));
      }

      log.info("Saving family info to DB...");

      // Now that payment was successful, save everything to database.
      familyRepo.save(family);
    } catch (Exception e) {
      throw new RuntimeException(
          e.getMessage() + "There was an error processing your payment. Please get in touch with the organizers");
    }
    return family;
  }

  /**
   * Exposed wrapper for REST call
   * 
   * @param eventId
   * @param adultCount
   * @param childCount
   * @return
   */
  public BigDecimal calculateTotalCharge(String eventId, int adultCount, int childCount) {
    GricEvent event = eventRepo.findOne(eventId);
    return calculateTotalCharge(event, adultCount, childCount);
  }

  /**
   * Calculates the final fee for the event.
   * 
   * @param event
   * @param adultCount
   * @param childCount
   * @return
   */
  private BigDecimal calculateTotalCharge(GricEvent event, int adultCount, int childCount) {
    log.info("calculating total for: ");
    log.info("adultCount:" + adultCount + " , childCount:" + childCount);
    log.info("adultCost:" + event.getAdultCost() + " , childCost:" + event.getChildCost());

    // in cents
    BigDecimal adultCharge = event.getAdultCost().multiply(new BigDecimal(adultCount));
    BigDecimal childCharge = event.getChildCost().multiply(new BigDecimal(childCount));

    BigDecimal totalCharge = adultCharge.add(childCharge);

    log.info("Base total charge in cents : " + totalCharge);

    if (event.isTransactionFeeCharged()) {
      totalCharge = addStripeFeeToTotal(totalCharge);
      log.info("Final Total after Transaction Fee " + totalCharge);
    }

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
    List<Family> families = new ArrayList<>();
    familyRepo.findAll().forEach(families::add);
    return families;
  }

}

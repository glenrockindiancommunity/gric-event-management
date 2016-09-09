package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.model.FamilyMember;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DoEverything {

  private static final Logger log = LoggerFactory.getLogger(DoEverything.class);

  // === Pricing Variables ===

  // 30¢ per successful charge
  @Value("${stripe.fixed.fee}")
  private BigDecimal stripeFixedFee = new BigDecimal(0.3);

  // standard US pricing of 2.9%
  @Value("${stripe.transaction.percent}")
  private BigDecimal stripeTransactionPercent = new BigDecimal(0.029);
  @Value("${adult.cost}")
  private BigDecimal adultCost = new BigDecimal(40);
  @Value("${child.cost}")
  private BigDecimal childCost = new BigDecimal(20);
  @Value("${non.gr.markup}")
  private BigDecimal nonGRMarkup = new BigDecimal(0.1);

  @Autowired
  private Talk2MailChimp talk2MailChimp;

  @Autowired
  private Talk2Stripe talk2Stripe;

  @Autowired
  private FamilyRepository repository;

  /**
   * read method name
   * 
   * @param family
   */
  public void acceptPaymentSubscribeToMailChimpAndRegisterFamily(Family family) {

    log.info("Accepting payment for family " + family.toString());

    String primaryEmail = family.getPrimaryEmail();

    // Some pre-processing
    List<MailChimpSubscriber> subscribers = new ArrayList<MailChimpSubscriber>();
    for (FamilyMember member : family.getFamilyMembers()) {

      if (member.isPrimaryEmail()) {
        primaryEmail = member.getEmail();
      }

      if (member.isSubscribeEmail()) {
        subscribers.add(new MailChimpSubscriber(member.getFirstName(), member.getLastName(), member.getEmail()));
      }
    }

    try {

      // once the
      log.info("Calling Stripe to charge...");

      String stripeReceiptNumber = talk2Stripe.createCharge(primaryEmail, family.getAmount(),
          family.getStripeReceiptNumber());

      // reset it, as token id is just a temporary variable for it.
      family.setStripeReceiptNumber(stripeReceiptNumber);

      log.info("Saving family info to DB...");
      // Now that payment was successful, now save everything to database.
      repository.save(family);

    } catch (Exception e) {
      throw new RuntimeException("There was an error processing your payment. Please get in touch with the organizers");
    }

    log.info("Subscribing to mailchimp...");
    // This has to be Async and non-dependent on the tx, if it fails, we'll
    // revist as to why later
    talk2MailChimp.addSubscriber(subscribers);

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

    if (townCode != "GR") {
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

}
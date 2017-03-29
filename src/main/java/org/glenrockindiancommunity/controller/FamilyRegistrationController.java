package org.glenrockindiancommunity.controller;

import java.math.BigDecimal;

import org.glenrockindiancommunity.integrate.EventRegistration;
import org.glenrockindiancommunity.model.Family;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FamilyRegistrationController {

  private static final Logger log = LoggerFactory.getLogger(FamilyRegistrationController.class);

  @Autowired
  private EventRegistration doEverything;

  /**
   * Submit the form to db, all in!
   * 
   * @param family
   * @param model
   * @return
   */
  @PostMapping(path = "/register/family/{tokenId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String registerFamily(@PathVariable String tokenId, @RequestBody Family family, Model model) {
    log.info("Controller calling registerFamily");

    Integer eventId = family.getEventId();

    try {
      family.setStripeReceiptNumber(tokenId);
      family = doEverything.acceptPaymentAndRegisterFamily(eventId, family);
    } catch (Exception e) {
      log.error("Error submitting form " + e.getMessage());
      return "There was an error submitting your request " + e.getMessage() + "\n\n";
    }
    return "<p>See you soon at the " + eventId + ". </p> <p>Your card has been charged <b>$" + family.getAmount()
        + "</b> for the event </p> <p>Your event confirmation id is  <b>" + family.getFamilyNameCode()
        + "</b> and your payment confirmation id is <b>" + family.getStripeReceiptNumber() + "</b>. </p>";
  }

  /**
   * Calculate the final cost of the event. This needs a wrapper api
   * 
   * @param townCode
   * @param adultCount
   * @param childCount
   * @param model
   * @return
   */
  @GetMapping(path = "/register/calculatetotal/{eventId}/{adultCount}/{childCount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public BigDecimal calculateTotal(@PathVariable Integer eventId, @PathVariable int adultCount,
      @PathVariable int childCount) {
    log.info("Calculating cost...");
    return doEverything.calculateTotalCharge(eventId, adultCount, childCount);
  }

}

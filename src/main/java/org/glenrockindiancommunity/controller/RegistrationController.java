package org.glenrockindiancommunity.controller;

import java.math.BigDecimal;
import java.util.List;

import org.glenrockindiancommunity.integrate.DoEverything;
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
public class RegistrationController {

  private static final Logger log = LoggerFactory.getLogger(RegistrationController.class);

  @Autowired
  private DoEverything doEverything;

  /**
   * Submit the form to db, all in!
   * 
   * @param family
   * @param model
   * @return
   */
  @PostMapping(path = "/register/family/{tokenId}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String registerFamily(@PathVariable String tokenId, @RequestBody Family family, Model model) {

    log.info("Controller calling acceptPaymentSubscribeToMailChimpAndRegisterFamily");

    family.setStripeReceiptNumber(tokenId);

    try {
      family = doEverything.acceptPaymentSubscribeToMailChimpAndRegisterFamily(family);
    } catch (Exception e) {
      log.error("Error submitting form " + e.getMessage());
      return "There was an error submitting your request " + e.getMessage() + "\n\n";
    }
    return "See you soon at the Diwali Party!. Your event confirmation id is  <b>" + family.getFamilyNameCode()
        + "</b> and your payment confirmation id is <b>" + family.getStripeReceiptNumber() + "</b>";
  }

  /**
   * Calculate the final cost of the event.
   * 
   * @param townCode
   * @param adultCount
   * @param childCount
   * @param model
   * @return
   */
  @GetMapping(path = "/register/calculatetotal/{townCode}/{adultCount}/{childCount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public BigDecimal calculateTotal(@PathVariable String townCode, @PathVariable int adultCount,
      @PathVariable int childCount, Model model) {
    log.info("Calculating cost...");
    return doEverything.calculateTotalCharge(townCode, adultCount, childCount);
  }

  /**
   * Json response of all the users registered for the event so far...
   * 
   * @param model
   * @return
   */
  @GetMapping(path = "/register/showall", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public List<Family> showAllRegisteredUsers(Model model) {
    return doEverything.showAll();
  }

}

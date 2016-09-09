package org.glenrockindiancommunity.controller;

import java.math.BigDecimal;

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

  @PostMapping(path = "/register/family", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String registerFamily(@RequestBody Family family, Model model) {

    log.info("Controller calling acceptPaymentSubscribeToMailChimpAndRegisterFamily");

    doEverything.acceptPaymentSubscribeToMailChimpAndRegisterFamily(family);
    return "confirmed";
  }

  /**
   * Add the PvTv math from Stripe.
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
    return null;
  }


}

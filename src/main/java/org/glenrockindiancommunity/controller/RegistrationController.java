package org.glenrockindiancommunity.controller;

import java.math.BigDecimal;
import java.math.MathContext;

import org.glenrockindiancommunity.integrate.DoEverything;
import org.glenrockindiancommunity.model.Family;
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

  @Autowired
  private DoEverything doEverything;

  @PostMapping(path = "/register/family", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String registerFamily(@RequestBody Family family, Model model) {
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

    int perAdult = 4000;
    int perChild = 2000;
    float percent = 0.1f;

    int total = (perAdult * adultCount) + (perChild * childCount);

    BigDecimal totalValue = new BigDecimal(total);

    if (townCode != "GR") {
      totalValue = new BigDecimal(total + (total * percent));
    }

    totalValue.divide(BigDecimal.valueOf(100), BigDecimal.ROUND_UP);

    return addStripeFeeToTotal(totalValue);
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
    BigDecimal fFixed = new BigDecimal(0.3); // 30¢ per successful charge
    BigDecimal fPercent = new BigDecimal(0.029); // standard US pricing of 2.9%

    BigDecimal pCharge = pGoal.add(fFixed);
    fPercent = new BigDecimal(1).subtract(fPercent);
    pCharge = pCharge.divide(fPercent, 2, BigDecimal.ROUND_CEILING);

    return pCharge;
  }


}

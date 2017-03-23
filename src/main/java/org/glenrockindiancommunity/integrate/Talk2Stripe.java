package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.glenrockindiancommunity.GricConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;

@Component
public class Talk2Stripe {

  private static final Logger log = LoggerFactory.getLogger(Talk2Stripe.class);

  @Autowired
  private GricConfigProperties gricConfigProperties;

  /**
   * The checkout form only makes a token, the final charge happens using this
   * call.
   * 
   * @param email
   *          - Primary Email
   * @param amount
   *          - Amount to be charged.
   * @param token
   *          - Token created off "checkout"
   * @return
   * @throws AuthenticationException
   * @throws InvalidRequestException
   * @throws APIConnectionException
   * @throws APIException
   * @throws CardException
   */
  public String createCharge(String email, BigDecimal amount, String token)
      throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {

    log.warn("Charging: " + email + " For: " + amount);

    try {

      // See your keys here: https://dashboard.stripe.com/account/apikeys
      Stripe.apiKey = gricConfigProperties.getStripeApiKey();

      // Create a charge: this will charge the user's card
      Map<String, Object> chargeParams = new HashMap<String, Object>();
      // Amount in cents, multiple by 100, and send it as integer for API.
      chargeParams.put("amount", amount.multiply(new BigDecimal("100")).intValueExact());
      chargeParams.put("currency", "usd");
      chargeParams.put("source", token);
      chargeParams.put("description", "Glen Rock Indian Community Event");
      chargeParams.put("receipt_email", email);
      chargeParams.put("statement_descriptor", "Glen Rock Indian Community Event");

      Charge charge = Charge.create(chargeParams);

      String chargeIdAndReceiptNumber = charge.getId() + "," + charge.getReceiptNumber();

      return chargeIdAndReceiptNumber;
    } catch (Exception e) {
      // The card has been declined
      log.error("Charge failed for: " + email + " For: " + amount);
      throw e;
    }
  }
}

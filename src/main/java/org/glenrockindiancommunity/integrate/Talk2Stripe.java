package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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

  // Set your secret key: remember to change this to your live secret
  // key in production
  @Value("${stripe.api.key}")
  private String stripeApiKey = "pk_test_8nOh4pljYTX09ZXSIAB9FB1o";

  /**
   * * The checkout form only makes a token, the final charge happens using this
   * call.
   * 
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
   */
  public String createCharge(String email, BigDecimal amount, String token)
      throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {

    log.warn("Charging: " + email + " For: " + amount);

    try {

      // See your keys here: https://dashboard.stripe.com/account/apikeys
      Stripe.apiKey = stripeApiKey;

      // Create a charge: this will charge the user's card
      Map<String, Object> chargeParams = new HashMap<String, Object>();
//      chargeParams.put("amount", amountInCents(amount)); // Amount in cents
      chargeParams.put("amount", amountInCents(new BigDecimal("1"))); // Amount in cents
      chargeParams.put("currency", "usd");
      chargeParams.put("source", token);
      chargeParams.put("description", "Glen Rock Indian Diwali Dhamaka - 2016");
      chargeParams.put("receipt_email", email);
      chargeParams.put("statement_descriptor", "GRIC Diwali 2016");

      Charge charge = Charge.create(chargeParams);

      String chargeIdAndReceiptNumber = charge.getId() + "," + charge.getReceiptNumber();

      return chargeIdAndReceiptNumber;
    } catch (CardException e) {
      // The card has been declined
      log.error("Charge failed for: " + email + " For: " + amount);
    }
    return null;
  }

  private Integer amountInCents(BigDecimal amount) {
    return (amount.intValue() * 100);
  }

}

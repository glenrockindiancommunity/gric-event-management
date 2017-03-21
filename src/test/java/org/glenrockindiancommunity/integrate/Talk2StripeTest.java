package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;

public class Talk2StripeTest {

  @Autowired
  Talk2Stripe talk2Stripe;

  private String token;

  /**
   * Make a transaction for testing a charge.
   */
  @Before
  public void setup() {

    this.token = "";

  }

  public void testCreateCharge()
      throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {
    talk2Stripe.createCharge("sample.", new BigDecimal("100"), token);

  }

}

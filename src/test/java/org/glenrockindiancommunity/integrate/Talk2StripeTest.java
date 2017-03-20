package org.glenrockindiancommunity.integrate;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
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

  @Test
  public void testCreateCharge()
      throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException, CardException {
    talk2Stripe.createCharge("sample.", new BigDecimal("100"), token);

  }

}

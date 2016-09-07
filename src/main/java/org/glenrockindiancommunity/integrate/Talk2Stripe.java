package org.glenrockindiancommunity.integrate;

import java.util.HashMap;
import java.util.Map;

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

	@Value("${stripe.api.key}")
	private String stripeApiKey = "sk_test_BQokikJOvBiI2HlWgH4olfQ2";

	/**
	 * The checkout form only makes a token, the final charge happens using this
	 * call.
	 * 
	 * @param token
	 *            Get the credit card details submitted by the form
	 * @return
	 * @throws APIException
	 * @throws APIConnectionException
	 * @throws InvalidRequestException
	 * @throws AuthenticationException
	 */
	public String createCharge(String email, Long amount, String token)
			throws AuthenticationException, InvalidRequestException, APIConnectionException, APIException {

		try {

			// Set your secret key: remember to change this to your live secret
			// key
			// in production

			// See your keys here: https://dashboard.stripe.com/account/apikeys
			Stripe.apiKey = stripeApiKey;

			// Create a charge: this will charge the user's card
			Map<String, Object> chargeParams = new HashMap<String, Object>();
			chargeParams.put("amount", 1000); // Amount in cents
			chargeParams.put("currency", "usd");
			chargeParams.put("source", token);
			chargeParams.put("description", "Example charge");
			chargeParams.put("receipt_email", email);

			Charge charge = Charge.create(chargeParams);
			
			String chargeId  = charge.getId(); 

			return charge.getReceiptNumber();
		} catch (CardException e) {
			// The card has been declined
		}
		return null;
	}

}

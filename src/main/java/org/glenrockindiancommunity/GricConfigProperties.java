package org.glenrockindiancommunity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Stripe API key is not part of the spring boot application.properties,
 * extending the property file to accommodate it.
 * 
 * @author vmehta
 *
 */
@ConfigurationProperties(prefix = "gric.app", ignoreUnknownFields = false, ignoreInvalidFields = false)
public class GricConfigProperties {

  // Set your secret key: remember to change this to your live secret
  // key in production
  private String stripeApiKey;

  public String getStripeApiKey() {
    return stripeApiKey;
  }

  public void setStripeApiKey(String stripeApiKey) {
    this.stripeApiKey = stripeApiKey;
  }

}

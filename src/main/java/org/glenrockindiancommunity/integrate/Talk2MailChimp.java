package org.glenrockindiancommunity.integrate;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;

/**
 * 
 * <code>
 * {
 *     "email_address": "urist.mcvankab@freddiesjokes.com",
 *     "status": "subscribed",
 *     "merge_fields": {
 *         "FNAME": "Urist",
 *         "LNAME": "McVankab"
 *     }
 * }
 * </code>
 * 
 * @author vmehta
 *
 */
@Component
public class Talk2MailChimp {

  private static final Logger log = LoggerFactory.getLogger(Talk2MailChimp.class);

  @Value("${mail.chimp.endpoint}")
  private String mailChimpEndpoint;

  @Value("${mail.chimp.list}")
  private String mailChimpList;

  private String mailChimpURL;

  @PostConstruct
  void buildMailChimpRESTUrl() {
    mailChimpURL = mailChimpEndpoint + "/" + mailChimpList;

    log.info("mailChimpURL " + mailChimpURL);
  }

  public void addSubscriber(List<MailChimpSubscriber> subscribers) {
    AsyncRestTemplate template = new AsyncRestTemplate();

    for (MailChimpSubscriber subscriber : subscribers) {
      log.info("Adding subscriber: " + subscriber.getEmailAddress());
      // template.postForEntity(mailChimpURL, re, responseType);
    }
  }

  public void addSubscriber(String firstname, String lastname, String email) {
    AsyncRestTemplate template = new AsyncRestTemplate();

    MailChimpSubscriber subscriber = new MailChimpSubscriber(firstname, lastname, email);

    log.info("Adding subscriber: " + subscriber.toString());
    // template.postForEntity(mailChimpURL, re, responseType);
  }
}

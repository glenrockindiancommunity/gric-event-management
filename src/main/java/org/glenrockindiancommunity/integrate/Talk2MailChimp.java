package org.glenrockindiancommunity.integrate;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.RestTemplate;

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

	@Value("${mail.chimp.endpoint}")
	private String mailChimpEndpoint;

	@Value("${mail.chimp.list}")
	private String mailChimpList;
	
	private String mailChimpURL;

	
	@PostConstruct
	void buildMailChimpRESTUrl() {
		mailChimpURL = mailChimpEndpoint + "/" + mailChimpList;
	
	}

	public void addSubscriber(List<MailChimpSubscriber> subscribers) {
		AsyncRestTemplate template = new AsyncRestTemplate();

		for (MailChimpSubscriber subscriber : subscribers) {
//			template.postForEntity(mailChimpURL, request, responseType);
		}
	}

}

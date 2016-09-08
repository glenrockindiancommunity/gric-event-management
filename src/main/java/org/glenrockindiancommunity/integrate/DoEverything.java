package org.glenrockindiancommunity.integrate;

import java.util.ArrayList;
import java.util.List;

import org.glenrockindiancommunity.model.Family;
import org.glenrockindiancommunity.model.FamilyMember;
import org.glenrockindiancommunity.respository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoEverything {

  @Autowired
  Talk2MailChimp talk2MailChimp;

  @Autowired
  Talk2Stripe talk2Stripe;

  @Autowired
  FamilyRepository repository;

  /**
   * read method name
   * 
   * @param family
   */
  public void acceptPaymentSubscribeToMailChimpAndRegisterFamily(Family family) {
    String primaryEmail = "";

    // Some pre-processing
    List<MailChimpSubscriber> subscribers = new ArrayList<MailChimpSubscriber>();
    for (FamilyMember member : family.getFamilyMembers()) {

      if (member.isPrimaryEmail()) {
        primaryEmail = member.getEmail();
      }

      if (member.isSubscribeEmail()) {
        subscribers.add(new MailChimpSubscriber(member.getFirstName(), member.getLastName(), member.getEmail()));
      }
    }

    try {

      // once the
      String stripeReceiptNumber = talk2Stripe.createCharge(primaryEmail, family.getAmount(), family.getStripeReceiptNumber());

      // reset it, as token id is just a temporary variable for it.
      family.setStripeReceiptNumber(stripeReceiptNumber);

      // Now that payment was successful, now save everything to database.
      repository.save(family);

    } catch (Exception e) {
      throw new RuntimeException("There was an error processing your payment. Please get in touch with the organizers");
    }

    // This has to be Async and non-dependent on the tx, if it fails, we'll
    // revist as to why later
    talk2MailChimp.addSubscriber(subscribers);

  }

}

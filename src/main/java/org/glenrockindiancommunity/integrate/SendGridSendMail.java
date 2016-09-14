package org.glenrockindiancommunity.integrate;

import org.springframework.stereotype.Component;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

//@Component
public class SendGridSendMail {

  public void sendMailOnSuccessfulRegistration() {
    SendGrid sendgrid = new SendGrid("sendgrid_username", "sendgrid_password");

    SendGrid.Email email = new SendGrid.Email();
    email.addTo("example@example.com");
    email.setFrom("other@example.com");
    email.setSubject("Hello World");
    email.setText("My first email through SendGrid");

    try {
      SendGrid.Response response = sendgrid.send(email);
    } catch (SendGridException e) {
      System.out.println(e);
    }

  }
}
package org.glenrockindiancommunity.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureMockRestServiceServer;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;


// @AutoConfigureMockRestServiceServer
//@RunWith(SpringRunner.class)
//@RestClientTest(EventRegistrationController.class)
public class RegistrationTests {

  @Autowired
  private EventRegistrationController service;

  @Autowired
  private MockRestServiceServer server;

  // /register/calculatetotal/{eventId}/{adultCount}/{childCount}
  //@Test
  public void  testCalcuateTotal() {
    this.server.expect(requestTo("/register/calculatetotal/1/2/0")).andRespond(withSuccess("200", MediaType.APPLICATION_JSON_UTF8));
    BigDecimal value = this.service.calculateTotal("1", 2, 0);
    assertThat(value).isEqualTo(200);
  }

}

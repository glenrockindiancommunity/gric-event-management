package org.glenrockindiancommunity.controller;

import java.math.BigDecimal;

import org.glenrockindiancommunity.model.Family;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

  @PostMapping(path = "/register/family", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public String registerFamily(@RequestBody Family family, Model model) {

    return "confirmed";
  }

  @GetMapping(path = "/register/calculatetotal/{townCode}/{adultCount}/{childCount}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public BigDecimal calculateTotal(@PathVariable String townCode, @PathVariable int adultCount,
      @PathVariable int childCount, Model model) {

    int perAdult = 4000;
    int perChild = 2000;
    float percent = 0.1f;

    int total = (perAdult * adultCount) + (perChild * childCount);

    BigDecimal totalValue = new BigDecimal(total);

    if (townCode != "GR") {
      totalValue = new BigDecimal(total + (total * percent));
    }

    return totalValue.divide(BigDecimal.valueOf(100), BigDecimal.ROUND_UP);
  }

}
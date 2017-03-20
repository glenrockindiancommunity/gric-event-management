package org.glenrockindiancommunity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(GricConfigProperties.class)
public class GricEventRegistration {

  private static final Logger log = LoggerFactory.getLogger(GricEventRegistration.class);

  public static void main(String[] args) {
    log.info("Starting server...");
    SpringApplication.run(GricEventRegistration.class, args);
  }

}

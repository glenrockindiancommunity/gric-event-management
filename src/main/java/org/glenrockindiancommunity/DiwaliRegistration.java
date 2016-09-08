package org.glenrockindiancommunity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
public class DiwaliRegistration {

  private static final Logger log = LoggerFactory.getLogger(DiwaliRegistration.class);

  public static void main(String[] args) {
    log.info("Starting server...");
    SpringApplication.run(DiwaliRegistration.class, args);
  }

  @Bean
  static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
    return new PropertySourcesPlaceholderConfigurer();
  }

}

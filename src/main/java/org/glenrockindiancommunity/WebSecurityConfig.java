package org.glenrockindiancommunity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  /**
   * Stuff which should not need authentication.
   */
  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/static/**").antMatchers("/favicon.ico");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http
//      .authorizeRequests()
//      .antMatchers(HttpMethod.POST, "/event/**")
//      .fullyAuthenticated();
    
    http
      .authorizeRequests()
      .antMatchers(HttpMethod.DELETE, "/**")
      .denyAll();
  
    http
      .antMatcher("/**")
      .authorizeRequests()
      .anyRequest().permitAll();
    
    // For REST calls (need more investigation)
    http.csrf().disable();
  }

}

package org.glenrockindiancommunity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/static/**").antMatchers("/favicon.ico");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/**").denyAll();

    http.httpBasic()
      .and().authorizeRequests()
      .antMatchers(HttpMethod.GET, "/event/**").permitAll()
      .antMatchers(HttpMethod.POST, "/family/**").permitAll()
      .antMatchers("/event/**")
        .hasRole("USER")
       .antMatchers("/family/**")
         .hasRole("USER")
       .and()
        .antMatcher("/**").authorizeRequests()
        .anyRequest().permitAll();

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

}
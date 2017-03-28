package org.glenrockindiancommunity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
    http.httpBasic().and().authorizeRequests()
            .antMatchers(HttpMethod.GET,"/event/**").permitAll()
      .antMatchers("/event/**")
        .hasRole("ADMIN")
      .and()
      .antMatcher("/**")
      .authorizeRequests()
      .anyRequest().permitAll();

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

  protected void configure(AuthenticationManagerBuilder auth)
          throws Exception {
    auth.inMemoryAuthentication().withUser("admin1").password("secret1")
            .roles("ADMIN");
  }
}

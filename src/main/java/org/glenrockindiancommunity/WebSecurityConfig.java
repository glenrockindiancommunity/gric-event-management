package org.glenrockindiancommunity;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    /**
     * Stuff which should not need authentication.
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**").antMatchers("/favicon.ico");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.DELETE, "/**")
                .denyAll();

        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/event/**").permitAll()
                .antMatchers("/event/**")
                .hasRole("ADMIN")
                .and().formLogin().loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
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

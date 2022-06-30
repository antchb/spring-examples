package com.antchb.examples.spring.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

// In Spring Security 5.7.0+ the WebSecurityConfigurerAdapter was deprecated. Spring encourages users to move 
// towards a component-based security configuration

// TODO: UPGRADE to 5.7.0+ style
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // TODO: Replace. Deprecated and unsafe. We use it just for testing 
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
            .withUser(userBuilder.username("admin").password("admin").roles("ADMIN"))
            .withUser(userBuilder.username("client").password("client").roles("CLIENT"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin().loginPage("/custom-login").loginProcessingUrl("/authenticateTheUser")
            .permitAll()
            .and()
            .logout().permitAll();
    }

}

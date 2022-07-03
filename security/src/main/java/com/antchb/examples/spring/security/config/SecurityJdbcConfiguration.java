package com.antchb.examples.spring.security.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// In Spring Security 5.7.0+ the WebSecurityConfigurerAdapter was deprecated. Spring encourages users to move 
// towards a component-based security configuration

// TODO: UPGRADE to 5.7.0+ style
@Configuration
@EnableWebSecurity
public class SecurityJdbcConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("select login_id as username, password as password, is_enabled as enabled " +
                                  "from spring_security.users where lower(login_id) = lower(?)")
            .authoritiesByUsernameQuery("select u.login_id as username, r.name as authority " +
                                        "from spring_security.user_roles ur " +
                                        "join spring_security.users u on ur.user_id = u.user_id " +
                                        "join spring_security.roles r on ur.role_id = r.role_id " +
                                        "where lower(u.login_id) = lower(?)")
            .passwordEncoder(new BCryptPasswordEncoder());
    }

    // Roles in the DB has prefix 'ROLE_'
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").hasRole("USER")
            .antMatchers("/admin/**").hasRole("ADMIN")
            .and()
            .formLogin().loginPage("/custom-login").loginProcessingUrl("/authenticateTheUser")
            .permitAll()
            .and()
            .logout().permitAll()
            .and()
            .exceptionHandling().accessDeniedPage("/access-denied");
    }

}

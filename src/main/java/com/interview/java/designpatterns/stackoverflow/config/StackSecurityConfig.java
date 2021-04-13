package com.interview.java.designpatterns.stackoverflow.config;

import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class StackSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}javainuse").roles("USER")
                .and()
                .withUser("admin").password("{noop}javainuse").roles("USER","ADMIN");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/stack/get/**").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/api/stack/").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/stack/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/api/stack/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/api/stack/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();

    }

}

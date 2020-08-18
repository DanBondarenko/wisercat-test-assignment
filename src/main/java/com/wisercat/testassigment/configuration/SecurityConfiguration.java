package com.wisercat.testassigment.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /**
     * 1. Disables HTTP Basic authentication for all pages.
     * 2. Redirects requests to HTTP to HTTPS.
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
             .csrf()
                .ignoringAntMatchers("/api/**") // Disable CSRF protection for api
            .and()
            .authorizeRequests(authorizeRequests ->
                authorizeRequests
                    .antMatchers("/**").permitAll()
            )
            .requiresChannel(requiresChannel ->
                requiresChannel
                    .anyRequest().requiresSecure()
            );
    }
}
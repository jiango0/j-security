package com.jzc.spring.boot.api.configuration;

import com.jzc.spring.boot.api.auth.CustomAuthenticationEntryPoint;
import com.jzc.spring.boot.api.auth.CustomLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class OAuth2Configuration extends ResourceServerConfigurerAdapter {

    @Autowired
    private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

    @Autowired
    private CustomLogoutSuccessHandler customLogoutSuccessHandler;

    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.exceptionHandling()
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .and()
                .logout()
                .logoutUrl("/oauth/logout")
                .logoutSuccessHandler(customLogoutSuccessHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/hello/").permitAll()
                .antMatchers("/secure/**").authenticated();
    }

}

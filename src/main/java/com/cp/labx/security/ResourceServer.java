package com.cp.labx.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.cp.labx.utils.ApplicationConstants;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter{

    @Override 
    public void configure(HttpSecurity http) throws Exception {
         // @formatter:off
         http
         .requestMatchers().antMatchers("/api", "/api/**")    
         .and()
         .authorizeRequests().anyRequest().access("#oauth2.hasScope('write')");
         // @formatter:on
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
         resources.resourceId(ApplicationConstants.RESOURCE_ID);
    }

}
package com.cp.labx.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication(scanBasePackages={"com.cp.labx"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
@EnableResourceServer
@EnableJpaAuditing
@EnableJpaRepositories("com.cp.labx.dao")
@EntityScan("com.cp.labx.model")
public class SpringBootRestApiApp {
 
    public static void main(String[] args) {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }
}

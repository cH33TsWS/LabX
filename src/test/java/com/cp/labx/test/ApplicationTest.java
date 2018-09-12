package com.cp.labx.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cp.labx.configuration.SpringBootRestApiApp;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = SpringBootRestApiApp.class)
@ActiveProfiles("test")
public class ApplicationTest {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;
	
	@Test
	public void test() {
		BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
		System.out.println(bCryptPasswordEncoder.encode("password"));
		
		UserDetails u = userDetailsService.loadUserByUsername("chandresh");
		System.out.println(u.getUsername() + " | " + u.getPassword());
		System.out.println(u.toString());
	}
}

package com.cp.labx.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	 public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
	 
	 @RequestMapping(value = "/hello", method = RequestMethod.GET)
	 public ResponseEntity<?> hello() {
	        return new ResponseEntity<String>("This is a test", HttpStatus.OK);
	 }
}

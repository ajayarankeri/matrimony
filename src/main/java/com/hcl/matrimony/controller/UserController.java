package com.hcl.matrimony.controller;

import javax.validation.Valid;

import org.apache.logging.slf4j.Log4jLoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.LoginUserDto;
import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.service.UserService;


@RestController
@RequestMapping("")
public class UserController {
	
	static Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterDto user) {
		userService.registerUser(user);
		log.info("You are registered successfully");
		return new ResponseEntity<>("You are registered successfully",HttpStatus.OK);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@Valid @RequestBody LoginUserDto loginUser) {
	   User user= userService.login(loginUser);
	   
	   if(ObjectUtils.isEmpty(user)) {
		   log.info("Please check credintials");
		   return new ResponseEntity<>("Please check credintials",HttpStatus.OK);
	   }else {
		   log.info("login Successfully");
		   return new ResponseEntity<>("login Successfully",HttpStatus.OK);
	   }
	}

}

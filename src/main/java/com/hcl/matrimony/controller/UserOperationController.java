package com.hcl.matrimony.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.UserRepository;
import com.hcl.matrimony.service.UserOperationService;


@RestController
public class UserOperationController{
	Logger logger = LoggerFactory.getLogger(UserOperationController.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOperationService userOperationService;
	
	@PostMapping("/search/{user_id}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("user_id")Long userId , @RequestBody SearchUserDto searchUser )throws ResourceNotFoundException{
		if(searchUser.getAgeFrom()==0&&searchUser.getAgeTo()==0)
			throw new ResourceNotFoundException("Please fill age from and age to parameter"); 
	 return new ResponseEntity<>(userOperationService.searchUser(searchUser,userId),HttpStatus.OK);
	}
	
	
	@PostMapping("/interest")
	public ResponseEntity<Object> saveInterestUser(@Valid @RequestBody InterestDto interestDto) throws ResourceNotFoundException, NoSameUserIdException{ 		
	   
		userOperationService.saveInterest(interestDto);
	   return new ResponseEntity<>("Interest save sucessfully",HttpStatus.OK);       
	}
	
	@PostMapping("/interest/{fortype}/{id}")
	public ResponseEntity<Object> getInterestUsers(@PathVariable("id") long id,@PathVariable("fortype") String type) throws ResourceNotFoundException{ 		
	   return new ResponseEntity<>(userOperationService.getInterrestedUserList(id,type),HttpStatus.OK);  
	}
}

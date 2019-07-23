package com.hcl.matrimony.controller;


import javax.validation.Valid;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.service.UserOperationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;
import com.hcl.matrimony.service.UserOperationService;

@RestController
public class UserOperationController{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOperationService userOperationService;
	
	@PostMapping("/search/{user_id}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("user_id")Long userId , @RequestBody SearchUserDto searchUser )throws ResourceNotFoundException{
		if(searchUser.getAgeFrom()==0&&searchUser.getAgeTo()==0)
			throw new ResourceNotFoundException("Please fill age from and age to parameter"); 
	 return new ResponseEntity<List<User>>(userOperationService.searchUser(searchUser,userId),HttpStatus.OK);
	}
	
	
	@PostMapping("/interest")
	ResponseEntity<Object> saveInterestUser(@Valid @RequestBody InterestDto interestDto) throws ResourceNotFoundException, NoSameUserIdException{ 		
	      userOperationService.saveInterest(interestDto);
	   return new ResponseEntity<>("Interest save sucessfully",HttpStatus.OK);       
	}
	
	@PostMapping("/interest/{fortype}/{id}")
	ResponseEntity<Object> getInterestUsers(@PathVariable("id") long id,@PathVariable("fortype") String type) throws ResourceNotFoundException{ 		
	   return new ResponseEntity<>(userOperationService.getInterrestedUserList(id,type),HttpStatus.OK);  
	}
}

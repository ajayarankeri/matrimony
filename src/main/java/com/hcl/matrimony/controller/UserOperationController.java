package com.hcl.matrimony.controller;


import javax.validation.Valid;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.service.UserOperationService;


import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;


@RestController
public class UserOperationController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOperationService userOperationService;
	
	@PostMapping("/serach/{user_id}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("user_id")Long user_id , @RequestBody SearchUserDto searchUser ){
		
		Optional<User> userList= userRepository.findById(user_id);
		String gender=null;
		if(userList.isPresent()) {
			gender=userList.get().getGender();
	 }
		return new ResponseEntity<List<User>>(userOperationService.searchUser(searchUser , gender),HttpStatus.OK);

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

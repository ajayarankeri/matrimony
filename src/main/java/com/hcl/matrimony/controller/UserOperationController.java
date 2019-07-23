package com.hcl.matrimony.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;
import com.hcl.matrimony.service.UserOperationService;

@RestController
public class UserOperationController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserOperationService userOperationService;
	
	@PostMapping("/serach/{user_id}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("user_id")Long user_id , @RequestBody SearchUserDto searchUser ){
		
		Optional<User> userList= userRepository.findById(user_id);
		User user=new User();
		String gender=null;
		if(!userList.isPresent()) {
			user=userList.get();
			gender=user.getGender();
	 }
		return new ResponseEntity<List<User>>(userOperationService.searchUser(searchUser , gender),HttpStatus.OK);
	}
}

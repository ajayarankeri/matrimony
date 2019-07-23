package com.hcl.matrimony.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;
@RestController
public class UserOperationController {
	
	UserRepository userRepository;
	
	
	@PostMapping("/serach/{user_id}")
	public ResponseEntity<List<User>> searchUser(@PathVariable("user_id")Long user_id , @RequestBody SearchUserDto searchUser ){
		
		Optional<User> userList= userRepository.findById(user_id);
		User user=new User();
		if(userList.isPresent()) {
		  user=userList.get();
		  String gender=user.getGender();
		  if(searchUser.getCommunity().isEmpty()&&(searchUser.getIncome()==0)&&searchUser.getQualification().isEmpty()&&
				  searchUser.getWorkLocation().isEmpty()) {
			  
			  
		  }
		  
			
		}
		
		
		return null;
		
	}
	

}

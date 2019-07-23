package com.hcl.matrimony.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.SearchUserDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;

@Service
public class UserOperationService {
	
	@Autowired
	UserRepository userRepository;
	
	public List<User> searchUser(SearchUserDto searchUser,String gender){
		 List<User> userList=new ArrayList<>();
	 if(searchUser.getCommunity().isEmpty()&&(searchUser.getIncome()==0)&&searchUser.getQualification().isEmpty()&&
		   searchUser.getWorkLocation().isEmpty()) {
	 userList =userRepository.searchUser(searchUser.getAge_from(),searchUser.getAge_to(),gender);
			  
	 }
	 else  if((searchUser.getIncome()==0)&&searchUser.getQualification().isEmpty()&& searchUser.getWorkLocation().isEmpty()) {
		userList=userRepository.searchUserByCommunity(searchUser.getAge_from(),searchUser.getAge_to(),gender,searchUser.getCommunity());
			
	}
	 else if(searchUser.getQualification().isEmpty()&& searchUser.getWorkLocation().isEmpty()){
		userList=userRepository.searchUserByCommunityAndIncome(searchUser.getAge_from(),searchUser.getAge_to(),gender,searchUser.getCommunity(),
					  searchUser.getIncome());
		  }
	 else if(searchUser.getWorkLocation().isEmpty())  {
		userList=userRepository.searchUserByCommunityIncomeAndQualification(searchUser.getAge_from(),searchUser.getAge_to(),gender,searchUser.getCommunity(),
				  searchUser.getIncome(),searchUser.getQualification());
	 }
	 else {
		 
		 userList=userRepository.searchUserByAllParameters(searchUser.getAge_from(),searchUser.getAge_to(),gender,searchUser.getCommunity(),
				  searchUser.getIncome(),searchUser.getQualification(),searchUser.getWorkLocation());
	 }
		return userList;
		
		
	}

}

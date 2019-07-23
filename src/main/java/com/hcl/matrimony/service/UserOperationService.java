package com.hcl.matrimony.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.entity.Interest;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.InterestRepository;
import com.hcl.matrimony.dto.SearchUserDto;


import com.hcl.matrimony.repository.UserRepository;

@Service
public class UserOperationService {


	@Autowired
	InterestRepository interestRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	public String saveInterest(InterestDto interestDto) throws ResourceNotFoundException, NoSameUserIdException {
		
		User interestUserObject=userRepository.findById(interestDto.getInterestUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    User userObject=userRepository.findById(interestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    Interest interestObject=new Interest();
	    if(interestUserObject.getUserId().equals(userObject.getUserId())) {
	    	throw new NoSameUserIdException("No same user id");
	    }
	    interestObject.setUserId(userObject);
	    interestObject.setInterestUserId(interestUserObject);
	    interestObject.setStatus(1);
	    interestRepository.save(interestObject);
	    
	    return "record save";
	}
	
	public List<User> getInterrestedUserList(long id,String type) throws ResourceNotFoundException{
		if(type.equals("who")) {
			return interestRepository.findInterestUserIdByWho(id);	
		}
		else if(type.equals("whom"))
		{
			return interestRepository.findInterestUserIdByWhom(id);
		}
		return null;
	}
	
	
	
	public List<User> searchUser(SearchUserDto searchUser,Long userId)throws ResourceNotFoundException{
		
		Optional<User> user= userRepository.findById(userId);
		String gender=null;
		if(user.isPresent()) {
			gender=user.get().getGender();
		}
		else {
			throw new ResourceNotFoundException("Invalid logged in user id");
		}
		 List<User> userList;
	    if(searchUser.getCommunity().isEmpty()&&(searchUser.getIncome()==0)&&searchUser.getQualification().isEmpty()&&
		   searchUser.getWorkLocation().isEmpty()) {
	       userList =userRepository.searchUser(searchUser.getAgeFrom(),searchUser.getAgeTo(),gender);
	    }
	    else  if((searchUser.getIncome()==0)&&searchUser.getQualification().isEmpty()&& searchUser.getWorkLocation().isEmpty()) {
		userList=userRepository.searchUserByCommunity(searchUser.getAgeFrom(),searchUser.getAgeTo(),gender,searchUser.getCommunity());
	   }
	    else if(searchUser.getQualification().isEmpty()&& searchUser.getWorkLocation().isEmpty()){
		userList=userRepository.searchUserByCommunityAndIncome(searchUser.getAgeFrom(),searchUser.getAgeTo(),gender,searchUser.getCommunity(),
					  searchUser.getIncome());
	   }
	   else if(searchUser.getWorkLocation().isEmpty())  {
		userList=userRepository.searchUserByCommunityIncomeAndQualification(searchUser.getAgeFrom(),searchUser.getAgeTo(),gender,searchUser.getCommunity(),
				  searchUser.getIncome(),searchUser.getQualification());
	 }
	 else {
		 
		 userList=userRepository.searchUserByAllParameters(searchUser.getAgeFrom(),searchUser.getAgeTo(),gender,searchUser.getCommunity(),
				  searchUser.getIncome(),searchUser.getQualification(),searchUser.getWorkLocation());
	 }
	    if(userList.isEmpty()) {
	    	throw new ResourceNotFoundException("No search result found");
	    }
		return userList;
		
		
	}

}

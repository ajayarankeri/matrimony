package com.hcl.matrimony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.entity.Interest;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.InterestRepository;
import com.hcl.matrimony.repository.UserRepository;

@Service
public class UserOperationService {

	@Autowired
	InterestRepository interestRepository;
	
	@Autowired
	UserRepository  userRepository;
	
	public void saveInterest(InterestDto interestDto) throws ResourceNotFoundException, NoSameUserIdException {
		
		User interestUserObject=userRepository.findById(interestDto.getInterestUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    User userObject=userRepository.findById(interestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    Interest interestObject=new Interest();
	    if(interestUserObject.getUserId()==userObject.getUserId()) {
	    	throw new NoSameUserIdException("No same user id");
	    }
	    interestObject.setUserId(userObject);
	    interestObject.setInterestUserId(interestUserObject);
	    interestObject.setStatus(1);
	    interestRepository.save(interestObject);
	}
	
	public List<User> getInterrestedUserList(long id,String type) throws ResourceNotFoundException{
		System.out.println("Type"+type);
		if(type.equals("who")) {
			System.out.println("Type"+type);
			return interestRepository.findInterestUserIdByWho(id);	
		}
		else if(type.equals("whom"))
		{
			return interestRepository.findInterestUserIdByWhom(id);
		}
		
		return null;
	}
	
	
}

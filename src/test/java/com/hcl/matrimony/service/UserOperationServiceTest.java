package com.hcl.matrimony.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;


import org.junit.Before;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.InterestRepository;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserOperationServiceTest {

	@InjectMocks
	 UserOperationService userOperationService;
	 
	@Mock
	 InterestRepository interestRepository;
	
	@Mock
	UserRepository userRepository;
	 
	InterestDto interrestDto;
	
	User userObject;
	User  interestUserObject;
	
	
	@Before
	public void setInterestDTO() {
       		interrestDto=new InterestDto();
       		interrestDto.setInterestUserId(1);
       		interrestDto.setUserId(2);
       		interrestDto.setStatus(1);
       		
       		userObject=new User();
       		userObject.setUserId(1l);
       		userObject.setAddress("Pune");
       		userObject.setAge(25);
       		userObject.setBirthDate(LocalDate.parse("2019-09-08"));
       		userObject.setFullName("vinayak desai");
       		userObject.setGender("M");
       		userObject.setIncome(2000);
       		userObject.setMobNo(915678903l);
       		userObject.setOccupation("SD");
       		userObject.setPassword("test");
       		userObject.setQualification("MCA");
       		userObject.setUserName("test123");
       		
       		interestUserObject=new User();
       		interestUserObject.setUserId(2l);
       		interestUserObject.setAddress("Pune");
       		interestUserObject.setAge(25);
       		interestUserObject .setBirthDate(LocalDate.parse("2019-09-08"));
       		interestUserObject.setFullName("vinayak desai");
       		interestUserObject.setGender("M");
       		interestUserObject.setIncome(2000);
       		interestUserObject.setMobNo(915678903l);
       		interestUserObject.setOccupation("SD");
       		interestUserObject.setPassword("test");
       		interestUserObject.setQualification("MCA");
       		interestUserObject.setUserName("test123");
       		
	}
	
	@Test
	public void saveInterestTest() throws ResourceNotFoundException, NoSameUserIdException {
	 when(userRepository.findById(1l).get()).thenReturn(userObject);
	 when(userRepository.findById(2l).get()).thenReturn(interestUserObject);
	 assertNotNull( userOperationService.saveInterest(interrestDto));
	}
}

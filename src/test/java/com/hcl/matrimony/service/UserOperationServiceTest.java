package com.hcl.matrimony.service;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.dto.InterestDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.InterestRepository;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserOperationServiceTest {

	@InjectMocks
	 UserOperationService userOperationService;
	 
	@Mock
	 InterestRepository interestRepository;
	
	@Mock
	UserRepository userRepository;
	 
	InterestDto interrestDto;
	InterestDto interrestDtoUpdate;
	
	private User userObject;
	private User  interestUserObject;
	
	
	@Before
	public void setInterestDTO() {
       		interrestDto=new InterestDto();
       		interrestDto.setInterestUserId(1);
       		interrestDto.setUserId(2);
       		interrestDto.setStatus(1);
       		
       		userObject=new User();
       		userObject.setUserId(Long.valueOf(2));
       		userObject.setAddress("Pune");
       		userObject.setAge(29);
       		userObject.setBirthDate(LocalDate.parse("2019-09-09"));
       		userObject.setFullName("Swapnil Patil");
       		userObject.setGender("M");
       		userObject.setIncome(10000);
       		userObject.setMobNo(9158022154l);
       		userObject.setOccupation("SD");
       		userObject.setPassword("test123");
       		userObject.setQualification("MCA");
       		userObject.setUserName("vinayak");
       		
       		interestUserObject=new User();
       		interestUserObject.setUserId(Long.valueOf(1));
       		interestUserObject.setAddress("Pune");
       		interestUserObject.setAge(29);
       		interestUserObject .setBirthDate(LocalDate.parse("2019-09-08"));
       		interestUserObject.setFullName("Vinayak Desai");
       		interestUserObject.setGender("M");
       		interestUserObject.setIncome(10000);
       		interestUserObject.setMobNo(9158022153l);
       		interestUserObject.setOccupation("SD");
       		interestUserObject.setPassword("test123");
       		interestUserObject.setQualification("MCA");
       		interestUserObject.setUserName("vinayak");
       		
	}
	
	@Test
	public void saveInterestTest() throws ResourceNotFoundException, NoSameUserIdException {
	when(userRepository.findById(Long.valueOf(2))).thenReturn(java.util.Optional.of(userObject));
   when(userRepository.findById(Long.valueOf(1))).thenReturn(java.util.Optional.of(interestUserObject));
	 assertNotNull( userOperationService.saveInterest(interrestDto));
	}
	

	@Test(expected = ResourceNotFoundException.class)
	public void saveInterestTestFail() throws ResourceNotFoundException, NoSameUserIdException {
		userObject=new User();
   		userObject.setUserId(Long.valueOf(2));
   		userObject.setAddress("Pune");
   		userObject.setAge(29);
   		userObject.setBirthDate(LocalDate.parse("2019-09-09"));
   		userObject.setFullName("Swapnil Patil");
   		userObject.setGender("M");
   		userObject.setIncome(10000);
   		userObject.setMobNo(9158022154l);
   		userObject.setOccupation("SD");
   		userObject.setPassword("test123");
   		userObject.setQualification("MCA");
   		userObject.setUserName("vinayak");
   		
   		interestUserObject=new User();
   		interestUserObject.setUserId(Long.valueOf(5));
   		interestUserObject.setAddress("Pune");
   		interestUserObject.setAge(29);
   		interestUserObject .setBirthDate(LocalDate.parse("2019-09-08"));
   		interestUserObject.setFullName("Vinayak Desai");
   		interestUserObject.setGender("M");
   		interestUserObject.setIncome(10000);
   		interestUserObject.setMobNo(9158022153l);
   		interestUserObject.setOccupation("SD");
   		interestUserObject.setPassword("test123");
   		interestUserObject.setQualification("MCA");
   		interestUserObject.setUserName("vinayak");
 
		when(userRepository.findById(Long.valueOf(5))).thenReturn(java.util.Optional.of(userObject));
	   when(userRepository.findById(Long.valueOf(6))).thenReturn(java.util.Optional.of(interestUserObject));
			
		interrestDtoUpdate=new InterestDto();
		interrestDtoUpdate.setInterestUserId(2);
		interrestDtoUpdate.setUserId(6);
   		interrestDto.setStatus(1);
		 assertNotNull( userOperationService.saveInterest(interrestDtoUpdate));
	}

	
	
	@Test
	public void saveInterestTestFailSecondUser() throws ResourceNotFoundException, NoSameUserIdException {
		userObject=new User();
   		userObject.setUserId(Long.valueOf(2));
   		userObject.setAddress("Pune");
   		userObject.setAge(29);
   		userObject.setBirthDate(LocalDate.parse("2019-09-09"));
   		userObject.setFullName("Swapnil Patil");
   		userObject.setGender("M");
   		userObject.setIncome(10000);
   		userObject.setMobNo(9158022154l);
   		userObject.setOccupation("SD");
   		userObject.setPassword("test123");
   		userObject.setQualification("MCA");
   		userObject.setUserName("vinayak");
   		
   		interestUserObject=new User();
   		interestUserObject.setUserId(Long.valueOf(5));
   		interestUserObject.setAddress("Pune");
   		interestUserObject.setAge(29);
   		interestUserObject .setBirthDate(LocalDate.parse("2019-09-08"));
   		interestUserObject.setFullName("Vinayak Desai");
   		interestUserObject.setGender("M");
   		interestUserObject.setIncome(10000);
   		interestUserObject.setMobNo(9158022153l);
   		interestUserObject.setOccupation("SD");
   		interestUserObject.setPassword("test123");
   		interestUserObject.setQualification("MCA");
   		interestUserObject.setUserName("vinayak");
 
		when(userRepository.findById(Long.valueOf(2))).thenReturn(java.util.Optional.of(userObject));
	   when(userRepository.findById(Long.valueOf(6))).thenReturn(java.util.Optional.of(interestUserObject));
			
		interrestDtoUpdate=new InterestDto();
		interrestDtoUpdate.setInterestUserId(2);
		interrestDtoUpdate.setUserId(6);
   		interrestDto.setStatus(1);
		 assertNotNull( userOperationService.saveInterest(interrestDtoUpdate));
	}

	@Test(expected = NoSameUserIdException.class)
	public void saveInterestTestFailForSameId() throws ResourceNotFoundException, NoSameUserIdException {
		userObject=new User();
   		userObject.setUserId(Long.valueOf(2));
   		userObject.setAddress("Pune");
   		userObject.setAge(29);
   		userObject.setBirthDate(LocalDate.parse("2019-09-09"));
   		userObject.setFullName("Swapnil Patil");
   		userObject.setGender("M");
   		userObject.setIncome(10000);
   		userObject.setMobNo(9158022154l);
   		userObject.setOccupation("SD");
   		userObject.setPassword("test123");
   		userObject.setQualification("MCA");
   		userObject.setUserName("vinayak");
   		
   		interestUserObject=new User();
   		interestUserObject.setUserId(Long.valueOf(2));
   		interestUserObject.setAddress("Pune");
   		interestUserObject.setAge(29);
   		interestUserObject .setBirthDate(LocalDate.parse("2019-09-08"));
   		interestUserObject.setFullName("Vinayak Desai");
   		interestUserObject.setGender("M");
   		interestUserObject.setIncome(10000);
   		interestUserObject.setMobNo(9158022153l);
   		interestUserObject.setOccupation("SD");
   		interestUserObject.setPassword("test123");
   		interestUserObject.setQualification("MCA");
   		interestUserObject.setUserName("vinayak");
 

		when(userRepository.findById(Long.valueOf(2))).thenReturn(java.util.Optional.of(userObject));
		//when(userRepository.findById(Long.valueOf(5))).thenReturn(java.util.Optional.of(interestUserObject));
			
		interrestDtoUpdate=new InterestDto();
		interrestDtoUpdate.setInterestUserId(2);
		interrestDtoUpdate.setUserId(2);
   		interrestDto.setStatus(1);
		 assertNotNull( userOperationService.saveInterest(interrestDtoUpdate));
	}
	
	@Test
	public void fetchUserList() throws ResourceNotFoundException {
		assertNotNull(userOperationService.getInterrestedUserList(1,"who"));
		assertNotNull(userOperationService.getInterrestedUserList(1,"whom"));
		assertNull(userOperationService.getInterrestedUserList(1,""));
	}
}

package com.hcl.matrimony.controller;

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
import com.hcl.matrimony.service.UserOperationService;

@RunWith(MockitoJUnitRunner.class)
public class UserOperationTestController {

	@InjectMocks
	UserOperationController userOperationController;
	
	@Mock
	UserOperationService userOperationService;
	
	private InterestDto interrestDto;
	@Before
	public void setInterestDTO() {
       		interrestDto=new InterestDto();
       		interrestDto.setInterestUserId(1);
       		interrestDto.setUserId(2);
       		interrestDto.setStatus(1);
       		  		
	}

	@Test
	public void saveInterestTest() throws ResourceNotFoundException, NoSameUserIdException {
		when(userOperationService.saveInterest(interrestDto)).thenReturn("record save");
		assertNotNull(userOperationController.saveInterestUser(interrestDto));
	}
	
	@Test
	public void serchUserList() throws ResourceNotFoundException {
		when(userOperationService.getInterrestedUserList(1, "")).thenReturn(null);
		assertNotNull(userOperationController.getInterestUsers(1, ""));
		
	}
}

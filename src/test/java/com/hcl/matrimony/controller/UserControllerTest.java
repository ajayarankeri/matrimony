package com.hcl.matrimony.controller;

import org.aspectj.lang.annotation.Before;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.dto.LoginUserDto;
import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

	@InjectMocks
	UserController userController;
	
	@Mock
	UserService userService;
	

	
	@Test
	public void testRegisterUser() {
		UserRegisterDto bookingDTO = new UserRegisterDto();
		
		Assert.assertNotNull(userController.registerUser(bookingDTO));
	} 
	
	@Test
	public void testLogin() {
		LoginUserDto loginDto=new LoginUserDto();
		loginDto.setUserName("ajay");
		loginDto.setPassword("ajay@123");
		User user=new User();
		
		Assert.assertNotNull(userController.loginUser(loginDto));
		
	}
}

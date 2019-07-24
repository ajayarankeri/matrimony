package com.hcl.matrimony.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;


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
	public void testLoginUser() {
		when(userService.login(new LoginUserDto())).thenReturn(new User());
		assertNotNull(userController.loginUser(new LoginUserDto()));
	}
	
}

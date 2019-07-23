package com.hcl.matrimony.service;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	public void registerUserTest() {
		UserRegisterDto userDto=new UserRegisterDto();
		userDto.setBirthDate(LocalDate.of(1993, 05, 12));
		userService.registerUser(userDto);
	}


}

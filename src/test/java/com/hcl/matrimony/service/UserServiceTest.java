package com.hcl.matrimony.service;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.matrimony.dto.LoginUserDto;
import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.entity.User;
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
	
	@Test
	public void loginTest() {
		//LoginUserDto loginUserDto=new LoginUserDto();
		User user=new User();
		userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
	}

	/*
	 * public User login(LoginUserDto loginUserDto) { 
	 * User user=new User();
	 * BeanUtils.copyProperties(loginUserDto, user); return userDetails=
	 * userRepository.findByUserNameAndPassword(user.getUserName(),
	 * user.getPassword()); }
	 */
}

package com.hcl.matrimony.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Period;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.BeanUtils;

import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	UserRegisterDto registerDto;
	
	@Before
	public void setUp() {
		registerDto=new UserRegisterDto();
		
		registerDto.setUserName("ajay");
		registerDto.setPassword("ajay@123");
		registerDto.setGender("M");
		registerDto.setBirthDate(LocalDate.of(1993, 05, 12));
		registerDto.setQualification("BCA");
		registerDto.setOccupation("Enginner");
		registerDto.setMobNo(7786767687L);
		registerDto.setAddress("pune");
		registerDto.setIncome(40000);
		registerDto.setCommunity("maratha");
		
	}
	
	@Test
	public void registerUserTest() {
		UserRegisterDto userDto=new UserRegisterDto();
		userDto.setBirthDate(LocalDate.of(1993, 05, 12));
		userService.registerUser(userDto);
	}

}

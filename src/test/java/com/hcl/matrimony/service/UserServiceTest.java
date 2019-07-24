package com.hcl.matrimony.service;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

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
	
	User userObject;
	LoginUserDto loginDto;
	
	@Before
	public void setUp() {
		
		loginDto = new LoginUserDto();

		loginDto.setUserName("vinayak");
		loginDto.setPassword("test123");
		userObject=new User();
   		userObject.setUserId(Long.valueOf(1));
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
   		userObject.setCommunity("Hindu");
   		
	}
	
	@Test
	public void registerUserTest() {
		UserRegisterDto userDto=new UserRegisterDto();
		userDto.setBirthDate(LocalDate.of(1993, 05, 12));
		userService.registerUser(userDto);
	}
	
	
	@Test
	public void TestLoginFaildSenario() {
		Mockito.when(userRepository.findByUserNameAndPassword("vinayak", "test123")).thenReturn(userObject);
		assertEquals(userObject.getUserId(), userService.login(loginDto).getUserId());
	}
}

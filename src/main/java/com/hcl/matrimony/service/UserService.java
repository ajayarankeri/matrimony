package com.hcl.matrimony.service;

import java.time.LocalDate;
import java.time.Period;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.LoginUserDto;
import com.hcl.matrimony.dto.UserRegisterDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.UserRepository;

@Service
public class UserService {
	
	static Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	UserRepository userRepository;


	public void registerUser(UserRegisterDto userDto) {
		User user=new User();
		BeanUtils.copyProperties(userDto, user);
		int age=Period.between(userDto.getBirthDate(),LocalDate.now()).getYears();
			user.setAge(age);
		userRepository.save(user);
		
	}

	public User login(LoginUserDto loginUserDto) {
		return  userRepository.findByUserNameAndPassword(loginUserDto.getUserName(), loginUserDto.getPassword());
	}

}

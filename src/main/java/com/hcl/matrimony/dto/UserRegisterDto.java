package com.hcl.matrimony.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserRegisterDto {

	private String userName;
	private String fullName;
	private String password;	
	private String gender;
	private LocalDate birthDate;
	private String qualification;	
	private String occupation;	
	private Long mobNo;
	private String address;	
	private int income;
}

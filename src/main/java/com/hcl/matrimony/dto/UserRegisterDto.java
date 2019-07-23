package com.hcl.matrimony.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import lombok.Data;

@Data
public class UserRegisterDto {

	@Column(name="user_name")
	private String userName;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@Column(name="qualification")
	private String qualification;
	
	@Column(name="occupation")
	private String occupation;
	
	@Column(name="mob_no")
	private Long mobNo;
	
	@Column(name="address")
	private String address;
	
	@Column(name="income")
	private int income;
}

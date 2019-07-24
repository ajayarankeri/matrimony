package com.hcl.matrimony.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRegisterDto {
	@NotNull
	private String userName;
	
	@NotNull
	private String fullName;
	
	@NotNull
	private String password;
	
	@NotNull
	private String gender;
	
	@NotNull
	private LocalDate birthDate;
	
	@NotNull
	private String qualification;	
	
	@NotNull
	private String occupation;	
	
	@NotNull
	private Long mobNo;
	
	@NotNull
	private String address;	
	
	@NotNull
	private int income;
	
	@NotNull
	private String community;
}

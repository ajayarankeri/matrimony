package com.hcl.matrimony.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserRegisterDto {
	
	@NotNull(message = "userName must not be null")
	@NotEmpty(message = "userName must not be empty")
	private String userName;
	
	@NotNull(message = "password must not be null")
	private String fullName;
	
	@NotNull(message = "password must not be null")
	@NotEmpty(message = "password must not be empty")
	private String password;
	
	@NotNull(message = "gender must not be null")
	private String gender;
	
	@NotNull(message = "birthDate must not be null")
	private LocalDate birthDate;
	
	@NotNull(message = "qualification must not be null")
	private String qualification;	
	
	@NotNull(message = "occupation must not be null")
	private String occupation;	
	
	@NotNull(message = "mobNo must not be null")
	private Long mobNo;
	
	@NotNull(message = "address must not be null")
	private String address;	
	
	@NotNull(message = "income must not be null")
	private int income;
	
	@NotNull(message = "community must not be null")
	private String community;
}

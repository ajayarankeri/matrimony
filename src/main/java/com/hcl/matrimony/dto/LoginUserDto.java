package com.hcl.matrimony.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginUserDto {
	
	@NotNull
	@NotEmpty(message = "userName must not be empty")
	private String userName;
	
	@NotNull
	@NotEmpty(message = "password must not be empty")
	private String password;

}

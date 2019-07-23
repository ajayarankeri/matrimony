package com.hcl.matrimony.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class LoginUserDto {
	@NotNull
	private String userName;
	
	@NotNull
	private String password;

}

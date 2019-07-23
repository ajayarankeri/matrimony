package com.hcl.matrimony.dto;

import javax.validation.constraints.Min;

import lombok.Data;
@Data
public class InterestDto {
	@Min(value = 1,message = "Please enter user id")
	private long userId;
	@Min(value = 1,message = "Please enter interested user id")
	private long interestUserId;	
	private int status;
}

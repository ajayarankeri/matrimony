package com.hcl.matrimony.dto;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
@Data
public class InterestDto {
	@Min(value = 1,message = "Please enter user id")
	private long userId;
	@Min(value = 1,message = "Please enter interested user id")
	private long interestUserId;	
	private int status;
}

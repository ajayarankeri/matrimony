package com.hcl.matrimony.dto;

import lombok.Data;

@Data
public class SearchUserDto {
	
	private int ageFrom;
	private int ageTo;
	private String qualification;
	private String workLocation;
	private String community;
	private long income;
	
	}

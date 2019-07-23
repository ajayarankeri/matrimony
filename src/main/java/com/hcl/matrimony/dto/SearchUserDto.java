package com.hcl.matrimony.dto;

import lombok.Data;

@Data
public class SearchUserDto {
	
	private int age_from;
	private int age_to;
	private String qualification;
	private String workLocation;
	private String community;
	private long income;
	
	}

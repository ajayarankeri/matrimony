package com.hcl.matrimony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.dto.FavouriteDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.FavouriteRepository;
import com.hcl.matrimony.service.FavouriteService;


//@RestController
@RequestMapping("/favourite")
public class FavouriteController {
	@Autowired
	FavouriteService favouriteService;
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	@PostMapping("/addfavourite")
	public ResponseEntity<Object> addfavourite(@RequestBody FavouriteDto favouriteDto) throws ResourceNotFoundException, NoSameUserIdException {
		favouriteService.addfavourite(favouriteDto);
		return new ResponseEntity<> ("Favourite added sucessfully",HttpStatus.OK);	
	}
	
	@GetMapping(value= "/followings/{userId}")
	public ResponseEntity<List<User>> followings(@PathVariable Long userId) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.OK;
		List<User> followingsDetails= favouriteService.followings(userId);
		return new ResponseEntity<>(followingsDetails,headers,httpStatus);
	}
	
	@GetMapping(value= "/followers/{userId}")
	public ResponseEntity<List<User>> followers(@PathVariable Long userId) {
		HttpHeaders headers = new HttpHeaders();
		HttpStatus httpStatus = HttpStatus.OK;
		List<User> followersDetails= favouriteService.followers(userId);
		return new ResponseEntity<>(followersDetails,headers,httpStatus);
	}
	
	
	

}

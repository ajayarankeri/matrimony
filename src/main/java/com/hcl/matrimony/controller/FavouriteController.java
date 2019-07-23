package com.hcl.matrimony.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.matrimony.entity.Favourite;
import com.hcl.matrimony.service.FavouriteService;


@RestController
@RequestMapping("/favourite")
public class FavouriteController {
	@Autowired
	FavouriteService favouriteService;
	
	@PostMapping("/addfavourite")
	public ResponseEntity<Object> addfavourite(@RequestBody Favourite favorite) {
		FavouriteService.addfavourite(favorite);
		return new ResponseEntity<> ("User added as your favorite sucessfully",HttpStatus.OK);	
	}
	

}

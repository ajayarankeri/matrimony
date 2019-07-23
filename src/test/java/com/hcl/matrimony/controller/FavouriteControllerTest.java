package com.hcl.matrimony.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hcl.matrimony.dto.FavouriteDto;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.service.FavouriteService;

@RunWith(MockitoJUnitRunner.class)
public class FavouriteControllerTest {

	
	@InjectMocks
	FavouriteController favouriteController;
	
	@Mock
	FavouriteService favouriteService;
	@Test
	public void testAddfavourite() throws ResourceNotFoundException, NoSameUserIdException {
		FavouriteDto favouriteDto=new FavouriteDto();
		Assert.assertNotNull(favouriteController.addfavourite(favouriteDto));
	}
	
	@Test
	public void testFollowings(){
		List<User> followingsDetails= new ArrayList<User>() ;
		when(favouriteService.followings(1L)).thenReturn(followingsDetails);
	}

}

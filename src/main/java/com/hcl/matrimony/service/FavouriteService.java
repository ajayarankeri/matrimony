package com.hcl.matrimony.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.dto.FavouriteDto;
import com.hcl.matrimony.entity.Favourite;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.exception.NoSameUserIdException;
import com.hcl.matrimony.exception.ResourceNotFoundException;
import com.hcl.matrimony.repository.FavouriteRepository;
import com.hcl.matrimony.repository.UserRepository;

@Service
public class FavouriteService {
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	@Autowired
	UserRepository userRepository;

	public void addfavourite(FavouriteDto favouriteDto) throws ResourceNotFoundException, NoSameUserIdException {
		User favouriteUserObject=userRepository.findById(favouriteDto.getFavoriteUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    User userObject=userRepository.findById(favouriteDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("User id not found"));
	    Favourite favourite=new Favourite();
	    if(favouriteUserObject.getUserId().equals(userObject.getUserId())) {
	    	throw new NoSameUserIdException("Same User id cannot be added");
	    }
	    favourite.setUserId(userObject);
	    favourite.setFavoriteUserId(favouriteUserObject);
	    favourite.setUpdatedDate(LocalDate.now());
		
		favouriteRepository.save(favourite);
	}

	public List<User> followings(Long userId) {
	  return favouriteRepository.findfollowings(userId);
	
	}

	public List<User> followers(Long userId) {
		 return	favouriteRepository.findfollowers(userId);
			
	}
}

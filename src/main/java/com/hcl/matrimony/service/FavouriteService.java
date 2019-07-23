package com.hcl.matrimony.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.matrimony.entity.Favourite;
import com.hcl.matrimony.entity.User;
import com.hcl.matrimony.repository.FavouriteRepository;
import com.hcl.matrimony.repository.UserRepository;

@Service
public class FavouriteService {
	
	@Autowired
	FavouriteRepository favouriteRepository;
	
	@Autowired
	UserRepository userRepository;

	public void addfavourite(Favourite favourite) {
		// TODO Auto-generated method stub
		favouriteRepository.save(favourite);
	}

	public List<User> myfavourite(Long userId) {
		// TODO Auto-generated method stub
		userRepository.findById(userId);
		
		return null;
	}
}

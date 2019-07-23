package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.Favourite;
import com.hcl.matrimony.entity.User;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, Long> {

	@Query("select u from User u , Favourite f where u.userId=f.favoriteUserId.userId and f.userId.userId=:id")
	List<User> findfollowings(@Param("id") Long userId);

	@Query("select u from User u , Favourite f where u.userId=f.userId.userId and f.favoriteUserId.userId=:id")
	List<User> findfollowers(@Param("id") Long userId);

}

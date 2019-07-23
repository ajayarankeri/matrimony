package com.hcl.matrimony.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.Interest;
import com.hcl.matrimony.entity.User;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {
    @Query("select u from User u,Interest i where  u.userId=i.interestUserId.userId and i.userId.userId=:id")
	List<User> findInterestUserIdByWhom(@Param("id") long id);
    
    @Query("select u from User u,Interest i where  u.userId=i.userId.userId and i.interestUserId.userId=:id")
   	List<User> findInterestUserIdByWho(@Param("id") long id);
}

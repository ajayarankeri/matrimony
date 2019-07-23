package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.Favorite;

@Repository
public interface FavouriteListRepository extends JpaRepository<Favorite, Long> {

}

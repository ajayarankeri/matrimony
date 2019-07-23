package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.matrimony.entity.Favourite;

@Repository
public interface FavouriteListRepository extends JpaRepository<Favourite, Long> {

}

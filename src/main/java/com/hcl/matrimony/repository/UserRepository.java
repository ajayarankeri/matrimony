package com.hcl.matrimony.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.matrimony.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

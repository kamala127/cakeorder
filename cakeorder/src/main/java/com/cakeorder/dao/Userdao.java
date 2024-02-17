package com.cakeorder.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cakeorder.Entity.User;

public interface Userdao extends JpaRepository<User, Long> {

	@Query("select u from User u")
	List<User> getAll();
	


}

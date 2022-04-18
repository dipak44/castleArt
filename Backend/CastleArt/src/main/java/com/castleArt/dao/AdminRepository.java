package com.castleArt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.castleArt.entities.Admin;
import com.castleArt.entities.Customer;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	@Query(value="select * from admin a where a.username=:username and a.password=:password",nativeQuery = true)
	Admin findByUsernameAndPassword(String username, String password);
	

}

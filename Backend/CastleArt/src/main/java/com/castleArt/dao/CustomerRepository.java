package com.castleArt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	

	@Modifying
	@Query(value="delete from customer c where c.username=:username", nativeQuery = true)
	int deleteCustomer(String username);
	
	
	@Query(value="select * from customer c where c.username=:username and c.password=:password",nativeQuery = true)
	Customer findByUsernameAndPassword(String username, String password);
	
	
	@Query(value="select * from customer c where c.username = :username",nativeQuery = true)
	public Customer getCustomerByUsername(String username);

	@Query(value="select * from customer c where c.email = :email",nativeQuery = true)
	public Customer getCustomerByEmail(String email);
	
	@Modifying
	@Query(value="delete from customer c where c. customer_id=:customerId", nativeQuery = true)
	int deleteCustomer(int customerId);
	
	 
	
	
	
}

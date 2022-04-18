package com.castleArt.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import com.castleArt.entities.Customer;
import com.castleArt.entities.OrderDetails;

@Repository
public interface OrderRepository extends JpaRepository<Customer, Integer> {
	
}

package com.castleArt.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.CustomerDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;


@Service
public interface ICustomerService {
	boolean registerCustomer(Customer customer)throws IOException;

	List<CustomerDto> findAllCustomer();

	int deleteCustomer(String username);
	int deleteCustomer(int customerId);
	boolean updateCustomer(Customer customer, String username, String password);
	boolean updateCustomer(CustomerDto customerDto, String username);
	public Customer getCustomerByUsername(String username);

	Customer authenticateArtist(String username, String password);
	public Customer getCustomerByEmail(String email);
	
	
	

	 
}

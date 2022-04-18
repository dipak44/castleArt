package com.castleArt.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castleArt.aop.EmailSenderService;
import com.castleArt.dao.ArtistRepository;
import com.castleArt.dao.CustomerRepository;
import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.CustomerDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.exception.NotRegistredException;
import com.castleArt.exception.ResourceNotFoundException;

import javax.mail.MessagingException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.castleArt.aop.EmailSenderService;

import javax.mail.MessagingException;

@Service
@Transactional
@Configuration
@ComponentScan
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private EmailSenderService service;

	@Autowired
	CustomerRepository customerrepo;

	@Autowired
	ArtistRepository artistrepo;

	@Override
	public List<CustomerDto> findAllCustomer() {
		// TODO Auto-generated method stub	
		List<Customer>customers =this.customerrepo.findAll();
		List<CustomerDto> customerDto= customers.stream().map(customer -> CustomerDto.fromEntitytoDto(customer)).collect(Collectors.toList());
		return customerDto;
	}

	@Override
	public int deleteCustomer(String username) {
		// TODO Auto-generated method stub	
		int b=customerrepo.deleteCustomer(username);
		return b;

	}

	@Override
	public boolean updateCustomer(Customer customer, String username, String password) {
		// TODO Auto-generated method stub

		Customer customer1=null;
		customer1=customerrepo.findByUsernameAndPassword(username,password);

		if(customer1==null)
			return false;
		else {

			customer1.setAddress(customer.getAddress());
			customer1.setPhoneNumber(customer.getPhoneNumber());
			customer1.setEmail(customer.getEmail());
			customer1.setCity(customer.getCity());
			customer1.setPostalCode(customer.getPostalCode());
			customer1.setState(customer.getState());

			customerrepo.save(customer1);
			return true;
		}
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return this.customerrepo.getCustomerByUsername(username);
	}

	@Override
	public Customer authenticateArtist(String username, String password) {
		// TODO Auto-generated method stub
		return customerrepo.findByUsernameAndPassword(username, password);
	}


	@Override
	public boolean registerCustomer(Customer customer) throws IOException {
		Customer cust1=null;	
		cust1=customerrepo.save(customer);
		if(cust1!=null)
		{

			String filePath = "D:\\Project_Storage_House\\artist.txt";

			// charset for encoding
			Charset encoding = Charset.defaultCharset();

			// reading all lines of file as List of strings
			byte[]  bytes = Files.readAllBytes(Paths.get(filePath));

			// converting List<String> to palin string using java 8 api.
			String string = new String(bytes, encoding);


			try {
				service.sendEmailWithAttachment(cust1.getEmail(),""+string+"","welcome to Castle art "+cust1.getFirstName()+" "+cust1.getLastName(),
						"D:\\Project_Storage_House\\Static_image\\CastleArt.jpg");


			}

			catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ResourceNotFoundException e1) {
				// TODO: handle exception
			}

			return true;
		}

		else {
			return false;
		}


	}

	@Override
	public Customer getCustomerByEmail(String email) {
		// TODO Auto-generated method stub
		return customerrepo.getCustomerByEmail(email);
	}

	@Override
	public int deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		int b=customerrepo.deleteCustomer(customerId);
		return b;
	}

	@Override
	public boolean updateCustomer(CustomerDto customerDto, String username) {
		// TODO Auto-generated method stub
		Customer customer1=null;
		customer1=customerrepo.getCustomerByUsername(username);

		if(customer1==null)
			return false;
		else {

			customer1.setAddress(customerDto.getAddress());
			customer1.setPhoneNumber(customerDto.getPhoneNumber());
			customer1.setEmail(customerDto.getEmail());
			customer1.setCity(customerDto.getCity());
			customer1.setPostalCode(customerDto.getPostalCode());
			customer1.setState(customerDto.getState());

			customerrepo.save(customer1);
			return true;
		}
	}


}

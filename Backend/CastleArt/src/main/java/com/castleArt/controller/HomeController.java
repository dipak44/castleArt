package com.castleArt.controller;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import javax.validation.executable.ValidateOnExecution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castleArt.aop.EmailSenderService;
import com.castleArt.dao.AdminRepository;
import com.castleArt.dao.ArtistRepository;
import com.castleArt.dto.Credentials;
import com.castleArt.dto.CustomerDto;
import com.castleArt.dto.ResponseDto;
import com.castleArt.entities.Admin;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.exception.UserNotFoundException;
import com.castleArt.exception.UsernameAlreadyPresentException;
import com.castleArt.service.IArtistService;
import com.castleArt.service.ICustomerService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/home/")
@Api(value = "Basic Public Resources for sign-up and sign-in", description = "All Sign-up and Login operation for all actors in projects")
@CrossOrigin(origins="http://localhost:3000")
@Validated
public class HomeController {

	@Autowired
	IArtistService artistService;

	@Autowired
	ICustomerService customerservice;

	@Autowired
	AdminRepository adminrepo;
	
	@Autowired
	private EmailSenderService service;


	//	@Autowired
	//	private BCryptPasswordEncoder passwordEncoder;	
	Random random = new Random(1000);


	// mapping for to register new artist
	@RequestMapping(value = "artist-signup", method = RequestMethod.POST)
	@ApiOperation(value = "Sign-up the Artist")
	public ResponseEntity<String> addArtist(@Valid @RequestBody  Artist artist)
	{
		artist.setRole("ROLE_ARTIST");
		System.out.println(artist);


		//	artist.setPassword(passwordEncoder.encode(artist.getPassword()));
		Artist artist1=null;
		try {
			//customer1=
			boolean b= artistService.registerArtist(artist);
			if(b==true)
				return ResponseEntity.ok("Artist  registeration is succesful");




			else 
			{
				throw new SQLIntegrityConstraintViolationException("reason");

			}
		} 
		catch (SQLIntegrityConstraintViolationException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
			//return new ResponseEntity<>("username already present!", HttpStatus.NOT_ACCEPTABLE);
			//e1.getMessage();
			//e1.addSuppressed(e1);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e1.getMessage());
		}
		catch (IOException e1) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e1.getMessage());

			// TODO: handle exception
		}
		//		 catch (Exception e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//			return new ResponseEntity<>("not Registred !", HttpStatus.NOT_ACCEPTABLE);
		//		}

		//Artist artistreg=artistService.registerArtist(artist);
		//return ResponseEntity.ok("artist  registeration is succesful");
	}



	// mapping for to register new customer
	@RequestMapping(value = "customer-signup", method = RequestMethod.POST)
	@ApiOperation(value = "Sign-up the Customer")
	public ResponseEntity<String> addCustomer(@Valid @RequestBody Customer customer) throws IOException
	{
		customer.setRole("ROLE_CUSTOMER");
		//customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer customer1=null;
		//customer1=
		boolean b= customerservice.registerCustomer(customer);
		if(b==true)
			return ResponseEntity.ok("customer  registeration is succesful");
		else 
			return new ResponseEntity<>("not Registred !", HttpStatus.NOT_ACCEPTABLE);

	} 


	@RequestMapping(value = "artist-signin", method = RequestMethod.POST)
	@ApiOperation(value = "Artist Login")
	public ResponseEntity<?> authenticateArtist(@RequestBody Credentials cred, HttpSession session ) throws UserNotFoundException {
		Artist artist = artistService.authenticateArtist(cred.getUsername(), cred.getPassword());
		if(artist!=null)
			return ResponseEntity.status(HttpStatus.OK).body(artist);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artist found for given credientials");

	}

	@RequestMapping(value = "customer-signin", method = RequestMethod.POST)
	@ApiOperation(value = "Customer Login")
	public ResponseEntity<?> authenticateCustomer(@RequestBody Credentials cred, HttpSession session ) throws UserNotFoundException {
		Customer customer = customerservice.authenticateArtist(cred.getUsername(), cred.getPassword());
		if(customer!=null)
			return ResponseEntity.status(HttpStatus.OK).body(customer);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No customer found for given credientials");

	}

	@RequestMapping(value = "admin-signin", method = RequestMethod.POST)
	@ApiOperation(value = "Admin Login")
	public ResponseEntity<?> authenticateAdmin(@RequestBody Credentials cred, HttpSession session ) throws UserNotFoundException {
		Admin admin = adminrepo.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());
		if(admin!=null)
			return ResponseEntity.status(HttpStatus.OK).body(admin);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid Login !! No Admin found for given credintilas");

	}

}

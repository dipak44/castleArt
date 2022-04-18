package com.castleArt.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.CustomerDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.entities.Order;
import com.castleArt.service.IArtistService;
import com.castleArt.service.ICustomerService;
import com.castleArt.service.IOrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("api/customer")
@Api(value = "customers Resources", description = "all operation related to customer")
@CrossOrigin(origins="http://localhost:3000")
public class CustomerController {


	@Autowired
	ICustomerService customerservice;

	@Autowired
	IArtistService artistService;
	
	@Autowired
	IOrderService ioOrderService;



	// delete the customer using username in their dashord
	@ApiOperation(value = "Delete the Customer")
	@DeleteMapping("/delete-customer-account/{username}")
	public ResponseEntity<?> deleteArtist(@RequestParam ("username")String username) {
		try {
			System.out.println("your username :"+username);
			int b= customerservice.deleteCustomer(username);
			if(b!=0)
			{
			return ResponseEntity.status(HttpStatus.OK).body("Customer Deleted Succesfully");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("customer not deleted ");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	// delete the customer by customer id by admin
	@ApiOperation(value = "Delete the Customer")
	@DeleteMapping("/delete-customer-account-byId/{customerId}")
	public ResponseEntity<?> deleteArtist(@RequestParam ("customerId")int customerId) {
		try {
			System.out.println("your customerId is :"+customerId);
			int b= customerservice.deleteCustomer(customerId);
			if(b!=0)
			{
			return ResponseEntity.status(HttpStatus.OK).body("Customer Deleted Succesfully");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("customer  not deleted ");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	
	
	@ApiOperation(value = "Find all the Artist who are available for Service")
	@GetMapping("/find-all-service-artist")   
	public ResponseEntity<List<ArtistDto>> findallserviceartist() {

		List<ArtistDto> list =artistService.findAllServiceArtist();
		if (list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}

	@ApiOperation(value = "Find Artist by Name")
	@GetMapping("/find-artist-byname/{firstName}")
	public ResponseEntity<?> getbyName(@PathVariable ("firstName") String firstName) {
		System.out.println("given artistName is :"+firstName);
		List<ArtistDto> artist2= artistService.getArtistDetailsbyName(firstName);
		if (artist2.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No artists is present for given name");
		}
		return ResponseEntity.of(Optional.of(artist2));
	}
	
	
	// update the customer information
		@ApiOperation(value = "Update the customer information")
			@PutMapping("/update/{username}")
			public ResponseEntity<?> updateCustomer(@RequestBody CustomerDto customerDto, @PathVariable ("username") String username) {

				try {
					
					boolean status=this.customerservice.updateCustomer(customerDto,username);
					if(status==true)
					return ResponseEntity.status(HttpStatus.OK).body("Customer updated  succesfully");
					else {
						return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no customer found");
						//return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
					}
				} catch (Exception e) {
					e.printStackTrace();
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
				}   
			}     

		// mapping for order table
		@PostMapping("/order")
		public ResponseEntity<String> order(@RequestBody Order order)
		{

			try {
				int n=ioOrderService.saveorder(order);
				if(n!=0)
				{
					return ResponseEntity.status(HttpStatus.OK).body("order added succesfully");
				}
				else
				{
					return ResponseEntity.status(HttpStatus.OK).body("order added succesfully");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}


	
	
	
	
	
	
	
	
	
	
	
}
 package com.castleArt.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.CustomerDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.service.IArtistService;
import com.castleArt.service.ICustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/admin")
@Api(value = "Admin Resources", description = "all operation related to Admin...")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {
	
	
	@Autowired
	IArtistService artistService;
	
	@Autowired
	ICustomerService customerservice;
	
	// to find all artist who are register 
	@ApiOperation(value = "Find the all Artist")
	@GetMapping("/find-all-artists")
    public ResponseEntity<List<ArtistDto>> getAllArtist() {

        List<ArtistDto> list = artistService.findAllArtist();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.OK).build();
           
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(list);
	}
	
	// search artist by artist id
	@ApiOperation(value = "Search the Artist by id")
	@GetMapping("/search-artist-byid/{artistId}")
    public ResponseEntity<?> getartistbyId(@RequestParam ("artistId") int artistId) {
    	System.out.println("given id is "+artistId);
        Artist artist1= artistService.getArtistDetailsbyId(artistId);
        if (artist1 == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not present");
        }
        return ResponseEntity.of(Optional.of(artist1));
    }
	
	//find all customer 
	@ApiOperation(value = "Find all Customer")
	@GetMapping("/find-all-customers")
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {

        List<CustomerDto> list = customerservice.findAllCustomer();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
           
        }
        return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
    

}

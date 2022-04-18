package com.castleArt.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.castleArt.dto.ArtistDto;
import com.castleArt.dto.ResponseDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.service.IArtistService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api/artist")
@Api(value = "Artist Resources", description = "all operation related to Artist")
@CrossOrigin(origins="http://localhost:3000")
public class ArtistController {

	@Autowired
	IArtistService artistService;


	


	// delete artist account
	@ApiOperation(value = "Delete the Artist")
	@DeleteMapping("/delete-artist-accountByUsername/{username}")
	public ResponseEntity<?> deleteArtistbyUsername(@PathVariable ("username") String username) {
		try {

			//String username=principal.getName();
			System.out.println("your username :"+username);
			//Customer customerx = customerservice.getCustomerByUsername(username);
			boolean b= artistService.deleteArtist(username);
			if(b==true)
			{
				return ResponseEntity.status(HttpStatus.OK).body("artist deleted succesfully");
			}
			else
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body("artist  not deleted ");

			}
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	
	// delete artist account
		@ApiOperation(value = "Delete the Artist")
		@DeleteMapping("/delete-artist-account/{artistId}")
		public ResponseEntity<?> deleteArtist(@PathVariable ("artistId") int artistId) {
			try {

				//String username=principal.getName();
				System.out.println("your id :"+artistId);
				boolean b= artistService.deleteArtistbyid(artistId);
				if(b==true)
				{
					return ResponseEntity.status(HttpStatus.OK).body("artist deleted succesfully");
				}
				else
				{
					return ResponseEntity.status(HttpStatus.NO_CONTENT).body("artist  not deleted ");

				}
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}

		}


	// update the artist information
	@ApiOperation(value = "Update the Artist Personal Information")
	@PutMapping("/update/{username}")
	public ResponseEntity<?> updateArtist(@RequestBody ArtistDto artistDto, @PathVariable ("username") String username) {

		try {
			boolean status=this.artistService.updateArtist(artistDto, username);
			if(status==true)
			return ResponseEntity.status(HttpStatus.OK).body("artist updated  succesfully");
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no artist found");
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}   
	}     

}





package com.castleArt.service;

import java.io.IOException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.castleArt.dto.ArtistDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;

@Service
public interface IArtistService {
	boolean registerArtist(Artist artist)throws SQLIntegrityConstraintViolationException,IOException;
	
	List<ArtistDto> findAllArtist();
	
	public Artist getArtistDetailsbyId(int artistId);
	public List<ArtistDto>  getArtistDetailsbyName(String firstName);

	List<ArtistDto> findAllServiceArtist();
	 public boolean deleteArtist(String username);
	 public boolean deleteArtistbyid(int artistId);
	 public boolean updateArtist(ArtistDto artistDto,String username);
	 
	 public Artist getArtistByUsernameAndPassword(String username,String password);
	 public Artist authenticateArtist(String username, String password);
	 public Artist getArtistByUsername(String username);
	
	 


}

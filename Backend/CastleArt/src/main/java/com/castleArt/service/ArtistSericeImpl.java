package com.castleArt.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castleArt.aop.EmailSenderService;
import com.castleArt.dao.ArtistRepository;
import com.castleArt.dao.ProductRepository;
import com.castleArt.dto.ArtistDto;
import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;
import com.castleArt.exception.ResourceNotFoundException;
import com.castleArt.exception.UserNotFoundException;

@Service
public class ArtistSericeImpl implements IArtistService {


	@Autowired
	ArtistRepository artistrepo;

	@Autowired
	private EmailSenderService service;

	@Autowired
	ProductRepository productrepo;


	List<Artist> list;

//		@Override
//	public List<Artist> findAllArtist() {
//		//System.out.println("findAllCustomers in CustomerService class");
//		return artistrepo.findAll();
//	}
	
	@Override
	public List<ArtistDto> findAllArtist() {
		//System.out.println("findAllCustomers in CustomerService class");
		List<Artist>artists =this.artistrepo.findAll();
		List<ArtistDto> artistdtos= artists.stream().map(artist -> ArtistDto.fromEntitytoDto(artist)).collect(Collectors.toList());
		return artistdtos;
	
}
	
	

	@Override
	public Artist getArtistDetailsbyId(int artistId) {
		// TODO Auto-generated method stub
		//System.out.println("the given artist id is" +artistId);
		Artist artist = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			artist=this.artistrepo.findById(artistId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return artist;
	}


	@Override
	public List<ArtistDto> getArtistDetailsbyName(String firstName) {
		// TODO Auto-generated method stub
		
		
		
			List<Artist> artist1=this.artistrepo.findByFirstNameContaining(firstName);
			List<ArtistDto> artistdtos= artist1.stream().map(artist -> ArtistDto.fromEntitytoDto(artist)).collect(Collectors.toList());
		return artistdtos;
	}


	@Override
	public List<ArtistDto>  findAllServiceArtist() {
		// TODO Auto-generated method stub
		List<Artist> artists=this.artistrepo.findServiceArtist();
		List<ArtistDto> artistdtos= artists.stream().map(artist -> ArtistDto.fromEntitytoDto(artist)).collect(Collectors.toList());
		return artistdtos;
	}
	
	


	@Override
	public boolean deleteArtist(String username) {
		// TODO Auto-generated method stub
		Artist artist=artistrepo.findArtistByUsername(username);
		System.out.println(artist.getArtistId());
		//this.productrepo.deleteProductForArtist(username);
		int p=this.productrepo.deleteProductForArtist(artist.getArtistId());
	System.out.println(p+" products deleted for gven artist");
//	 boolean b=this.artistrepo.deleteById(artist.getArtistId());
	int b=this.artistrepo.deleteArtist(artist.getArtistId());
	if(b!=0)
		return true;
	else
		return false;
	}


	@SuppressWarnings("unused")
	@Override
	public boolean updateArtist(ArtistDto artistDto, String username) {
		//TODO Auto-generated method stub
		//Artist artist1=null;
		Artist artist1=artistrepo.findArtistByUsername(username);
		if(artist1==null)
			return false;
		else
		{

			artist1.setAddress(artistDto.getAddress());
			artist1.setArtistBio(artistDto.getArtistBio());
			artist1.setAvailiblity(artistDto.isAvailiblity());
			artist1.setPhoneNo(artistDto.getPhoneNo());
			artist1.setArtistEmail(artistDto.getArtistEmail());
			artist1.setStatus(artistDto.isStatus());
			artist1.setCity(artistDto.getCity());


			artistrepo.save(artist1);
			return true;
		}

	}


	@Override
	public Artist getArtistByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		Artist artist1=artistrepo.findByUsernameAndPassword(username,password);
		return artist1;

	}

	@Override
	public Artist authenticateArtist(String username, String password) throws UserNotFoundException
	{
		//return artistrepo.findByUsernameAndPassword(username, password).orElseThrow(()->new ResourceNotFoundException("user","username",username));
		return artistrepo.findByUsernameAndPassword(username, password);
	}
	
	
	
@Override
public boolean registerArtist(Artist artist) throws SQLIntegrityConstraintViolationException,IOException {
	// TODO Auto-generated method stub

	Artist artist1=null;	
	artist1=artistrepo.save(artist);
	if(artist1!=null)
	{
	
			 String filePath = "D:\\Project_Storage_House\\customer.txt";
			  
		        // charset for encoding
		        Charset encoding = Charset.defaultCharset();
		 
		        // reading all lines of file as List of strings
		        byte[]  bytes = Files.readAllBytes(Paths.get(filePath));
		         
		        // converting List<String> to palin string using java 8 api.
		        String string = new String(bytes, encoding);
		         
		        try {
				service.sendEmailWithAttachment(artist1.getArtistEmail(),""+string+"","welcome to Castle art "+artist1.getFirstName()+" "+artist1.getLastname(),
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
	
	else 
		return false;


}

// delete the artist by artistId
@Override
public boolean deleteArtistbyid(int artistId) {
	// TODO Auto-generated method stub
	// TODO Auto-generated method stub
			Artist artist=artistrepo.findById(artistId);
			System.out.println(artist.getArtistId());
			//this.productrepo.deleteProductForArtist(username);
			int p=this.productrepo.deleteProductForArtist(artist.getArtistId());
		System.out.println(p+" products deleted for given artist");
//		 boolean b=this.artistrepo.deleteById(artist.getArtistId());
		int b=this.artistrepo.deleteArtist(artist.getArtistId());
		if(b!=0)
			return true;
		else
			return false;
	
}



@Override
public Artist getArtistByUsername(String username) {
	// TODO Auto-generated method stub
	return artistrepo.findArtistByUsername(username);
}

}




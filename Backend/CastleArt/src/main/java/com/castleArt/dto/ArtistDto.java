package com.castleArt.dto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.castleArt.entities.Artist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class ArtistDto {

	private int artistId;

	 @NotNull(message = "username shouldn't be null")
	private String firstName;
	 @NotNull(message = "username shouldn't be null")
	private String lastname;
	private String gender;
	
	private String artistBio;
	 @Email(message = "invalid email address")
	 
	private String artistEmail;
	 @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	private long phoneNo;
	private int artistPrice;
	private boolean status;
	private boolean availiblity;
	private String address;
	private int postalCode;
	private String city;
	private String state;
	
	
	
	
	
	
	
		
	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getArtistBio() {
		return artistBio;
	}

	public void setArtistBio(String artistBio) {
		this.artistBio = artistBio;
	}

	public String getArtistEmail() {
		return artistEmail;
	}

	public void setArtistEmail(String artistEmail) {
		this.artistEmail = artistEmail;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getArtistPrice() {
		return artistPrice;
	}

	public void setArtistPrice(int artistPrice) {
		this.artistPrice = artistPrice;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isAvailiblity() {
		return availiblity;
	}

	public void setAvailiblity(boolean availiblity) {
		this.availiblity = availiblity;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public static ArtistDto fromEntitytoDto(Artist artist) {
		ArtistDto artistdto = new ArtistDto();
		//BeanUtils.copyProperties(artist, artistdto);
		BeanUtils.copyProperties(artist, artistdto);
		return artistdto;
	}

	public static Artist fromDtotoEntity(ArtistDto artistdto) {
		Artist artist = new Artist();
		BeanUtils.copyProperties(artistdto, artist);
		return artist;
	}
	
	
}
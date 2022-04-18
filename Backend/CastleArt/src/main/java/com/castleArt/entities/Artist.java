package com.castleArt.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Entity
@Data
//@AllArgsConstructor
@Builder
@Table(name="Artist")
public class Artist {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int artistId;
	
	private String firstName;
	
	private String lastname;

	private String gender;

	@Column(name = "artist_bio")
	private String artistBio;

	@Column(name = "artist_email")
    @Email(message = "Email should be valid")
	private String artistEmail;

	@Column(name = "phone_number",nullable = false,length= 10)
	@Size(message = "phone number must be 10 digit")
    @Pattern(regexp="(^$|[0-9]{10})")
    private long phoneNo;

	@Column(name = "artist_price")
	private int artistPrice;

	@Column(nullable = false)
	@Size(message = "status is mandatory")
	private boolean status;


	private boolean availiblity;
	
	private String address;
	
	
	@Column(name="postal_code",nullable = false)
	@Size(min=6,max=6,message = "pincode must be {max} digit")
	private int postalCode;
	
	
	@Column(nullable = false, length=20)
	@Size(max = 20,message =  "city name must be less than {max} character")
	private String city;
	
	@Column(nullable = false)
	@Size(max = 20,message =  "state name must be less {max} than character")
	private String state;
	
	private String role;
	


	@Column(nullable = false,unique = true)
	@Size(max=10,message = "usename must be less than {max} character")
	private String username;

	private String password;

 
	//net
	@OneToMany(mappedBy = "artist",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Product> product;

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}








public Artist(int artistId, String firstName, String lastname, String gender, String artistBio, String artistEmail,
		long phoneNo, int artistPrice, boolean status, boolean availiblity, String address, int postalCode, String city,
		String state, String role, String username, String password, List<Product> product) {
	super();
	this.artistId = artistId;
	this.firstName = firstName;
	this.lastname = lastname;
	this.gender = gender;
	this.artistBio = artistBio;
	this.artistEmail = artistEmail;
	this.phoneNo = phoneNo;
	this.artistPrice = artistPrice;
	this.status = status;
	this.availiblity = availiblity;
	this.address = address;
	this.postalCode = postalCode;
	this.city = city;
	this.state = state;
	this.role = role;
	this.username = username;
	this.password = password;
	this.product = product;
}



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

public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public void setAddress(String address) {
	this.address = address;
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

public void setAddressLine1(String address) {
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

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public List<Product> getProduct() {
	return product;
}

public void setProduct(List<Product> product) {
	this.product = product;
}




@Override
public String toString() {
	return "Artist [artistId=" + artistId + ", firstName=" + firstName + ", lastname=" + lastname + ", gender=" + gender
			+ ", artistBio=" + artistBio + ", artistEmail=" + artistEmail + ", phoneNo=" + phoneNo + ", artistPrice="
			+ artistPrice + ", status=" + status + ", availiblity=" + availiblity + ", address=" + address
			+ ", postalCode=" + postalCode + ", city=" + city + ", state=" + state + ", username=" + username
			+ ", password=" + password + ", product=" + product + "]";
}			
}




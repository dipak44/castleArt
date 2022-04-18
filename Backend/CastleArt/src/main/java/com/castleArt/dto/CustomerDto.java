package com.castleArt.dto;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.BeanUtils;

import com.castleArt.entities.Artist;
import com.castleArt.entities.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {


	private int customerId;

	@Size(max = 2, message = "phone number should be 10 digit only")
	private String firstName;

	@NotEmpty
	private String lastName;


	private String email;
	private String gender;

	@NotNull
	private String password;

	@Size(min=4,message="add min is 4 char")
	private String address;
	private int postalCode;
	private String city;
	private String state;
	private long phoneNumber;
	private String username;




	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public static CustomerDto fromEntitytoDto(Customer customer) {
		CustomerDto customerdto = new CustomerDto();
		//BeanUtils.copyProperties(artist, artistdto);
		BeanUtils.copyProperties(customer, customerdto);
		return customerdto;
	}

	public static Customer fromDtotoEntity(CustomerDto customerdto) {
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerdto, customer);
		return customer;
	}




}

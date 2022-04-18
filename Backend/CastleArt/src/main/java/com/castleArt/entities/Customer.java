package com.castleArt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;



@Entity
@Data
@AllArgsConstructor
@Builder

@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private int customerId;

	@NotEmpty
	private String firstName;
	
	@Size( max = 2, message = "phone number should be 10 digit only")
	private String lastName;
	
	@Email
	private String email;
	
	
	@Min(5)
	@NotNull
	@Column(length = 10)
	@Size( max = 10,min = 10, message = "phone number should be 10 digit only")
	private long phoneNumber;

	private String gender;
	
	private String role;
	
	@Column(nullable = false,unique = true)
	private String username;
	
	private String password;
	
	
	

	private String address;


	@Column(name = "postal_code", nullable = false)
	@Size(min=6,max=6,message = "pincode must be {max} digit")
	private int postalCode;

	@Column(nullable = false, length=10)
	 @Size(max = 20,message =  "address must be less than character")
	private String city;

	@Column(nullable = false)
	@Size(max = 10,message =  "state must be less than character")
	private String state;

	
	
	// cutomer to review ---one to many relation
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Review> review;
	
	
	@OneToMany(mappedBy = "customer1", cascade = CascadeType.ALL)
	private List<ArtistOrder> artistorder;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
	private List<Order> order;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Customer(int customerId, String firstName, String lastName, String email, @Min(5) long phoneNumber,
			String gender, String role, String username, String password, String address, int postalCode, String city,
			String state, List<Review> review, List<Order> order) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.role = role;
		this.username = username;
		this.password = password;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.state = state;
		this.review = review;
		this.order = order;
	}


	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}





	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", gender=" + gender + ", role=" + role + ", username="
				+ username + ", password=" + password + ", address=" + address + ", postalCode=" + postalCode
				+ ", city=" + city + ", state=" + state + ", review=" + review + ", order=" + order + "]";
	}

	
	
}

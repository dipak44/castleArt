package com.castleArt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminID;
	
	private String adminName;
	
	private String role;
	
	
	@Size(max=10,message = "usename must be less than {max} character")
	@Column(nullable = false,unique = true)
	private String username;
	
	@Column(name = "password",nullable = false) 
	@Size(min =6, max=10, message= "Password must be in the range of {min} -{max} character")
	private String password;

	
}

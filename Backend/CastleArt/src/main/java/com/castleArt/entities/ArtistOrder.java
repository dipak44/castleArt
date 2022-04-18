package com.castleArt.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="ArtistOrder")
public class ArtistOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "artist_orderid")
	private int artistOrderid;
	private Date orderDate;

	@ManyToOne
	@JoinColumn(name="artist_artistOrder")
	private Artist artist2;

	@ManyToOne
	@JoinColumn(name="customer_artistOrder")
	private Customer customer1;

	public int getArtistOrderid() {
		return artistOrderid;
	}

	public void setArtistOrderid(int artistOrderid) {
		this.artistOrderid = artistOrderid;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Artist getArtist2() {
		return artist2;
	}

	public void setArtist2(Artist artist2) {
		this.artist2 = artist2;
	}

	public Customer getCustomer1() {
		return customer1;
	}

	public void setCustomer1(Customer customer1) {
		this.customer1 = customer1;
	}	
}



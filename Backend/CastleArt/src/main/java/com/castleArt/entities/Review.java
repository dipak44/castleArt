package com.castleArt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Table(name="review")
public class Review {
	
	@Id
	@GeneratedValue
	//@Transient
	private int reviewid;
	
	
	@Column
	@Size(min = 0)
	private int likes;
	
	@Column(length = 150)
	@Size(message = "Max length upto 150 characters only")
	private String comments;
	
	@ManyToOne
	@JoinColumn(name="artist_review")
	private Artist artist3;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_review")
	private Customer customer;
	

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public String getComment() {
		return comments;
	}

	public void setComment(String comment) {
		this.comments = comment;
	}

	public int getReviewid() {
		return reviewid;
	}

	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Artist getArtist3() {
		return artist3;
	}

	public void setArtist3(Artist artist3) {
		this.artist3 = artist3;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}

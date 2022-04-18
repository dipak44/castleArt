package com.castleArt.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor

public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int productId;

	private String name;

	private String image;

	@Column(name="description", length = 150)
	@Size(message = "Max length upto 150 characters only")
	private String description;

	@Column(name = "unit_in_stock")
	@Size(min = 0)
	private int unitInStock;

	@Column(name = "unit_price")
	@Size(min = 0)
	private int unitPrice;

	private String category;

	private String subcategory;
	
	private double sellingprice;

	//net
	@ManyToOne	
	@JsonIgnore
	private  Artist artist;
	//	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Product(int productId, String name, String image, String description, int unitInStock, int unitPrice,
			String category, String subcategory, double sellingprice, Artist artist) {
		super();
		this.productId = productId;
		this.name = name;
		this.image = image;
		this.description = description;
		this.unitInStock = unitInStock;
		this.unitPrice = unitPrice;
		this.category = category;
		this.subcategory = subcategory;
		this.sellingprice = sellingprice;
		this.artist = artist;
	}

	
	public int getProductId() {
		return productId;
	}





	public void setProductId(int productId) {
		this.productId = productId;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}





	public int getUnitInStock() {
		return unitInStock;
	}





	public void setUnitInStock(int unitInStock) {
		this.unitInStock = unitInStock;
	}





	public int getUnitPrice() {
		return unitPrice;
	}





	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}





	public String getCategory() {
		return category;
	}





	public void setCategory(String category) {
		this.category = category;
	}





	public String getSubcategory() {
		return subcategory;
	}





	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}





	public double getSellingprice() {
		return sellingprice;
	}





	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}





	public Artist getArtist() {
		return artist;
	}





	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", image=" + image + ", description="
				+ description + ", unitInStock=" + unitInStock + ", unitPrice=" + unitPrice + ", category=" + category
				+ ", subcategory=" + subcategory + ", sellingprice=" + sellingprice + ", artist=" + artist + "]";
	}

}

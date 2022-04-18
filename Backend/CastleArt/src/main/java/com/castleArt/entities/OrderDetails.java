package com.castleArt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="order_details")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderdetailsId;
	
	@Column
	@Size(min = 1)
	private int quantity;
	
	private int totalAmount;
	
	@ManyToOne
	private Order order;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Product product;

	@Column
	@Size(min = 0)
	private int unitPrice;
	
	@Column
	@Size(min = 0)
	private int totalOrderPrice;

	public int getOrderdetailsId() {
		return orderdetailsId;
	}

	public void setOrderdetailsId(int orderdetailsId) {
		this.orderdetailsId = orderdetailsId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalOrderPrice() {
		return totalOrderPrice;
	}

	public void setTotalOrderPrice(int totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderdetailsId=" + orderdetailsId + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + ", order=" + order + ", product=" + product + ", unitPrice=" + unitPrice
				+ ", totalOrderPrice=" + totalOrderPrice + "]";
	}
	
	
}

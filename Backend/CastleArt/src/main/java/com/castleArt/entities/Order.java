package com.castleArt.entities;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	private String customerName;
	
	private Long phoneno;
	
	private String address;
	
	private String city;
	
	private String state;
	
	private int postalCode;
	
	private int productCost;
	
	private int total;
	
	private String status;	
	
	private Date orderDate;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
	private List <OrderDetails> orderdetails;
	
	
	
	
	

	public Order(int orderId, String customerName, Long phoneno, String address, String city, String state,
			int postalCode, int productCost, int total, String status, Date orderDate, Customer customer,
			List<OrderDetails> orderdetails) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
		this.phoneno = phoneno;
		this.address = address;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.productCost = productCost;
		this.total = total;
		this.status = status;
		this.orderDate = orderDate;
		this.customer = customer;
		this.orderdetails = orderdetails;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public int getProductCost() {
		return productCost;
	}

	public void setProductCost(int productCost) {
		this.productCost = productCost;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", customerName=" + customerName + ", phoneno=" + phoneno + ", address="
				+ address + ", city=" + city + ", state=" + state + ", postalCode=" + postalCode + ", productCost="
				+ productCost + ", total=" + total + ", status=" + status + ", orderDate=" + orderDate + ", customer="
				+ customer + ", orderdetails=" + orderdetails + "]";
	}
}


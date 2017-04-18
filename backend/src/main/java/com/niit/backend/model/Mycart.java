package com.niit.backend.model;


	import java.util.Date;

	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Column;
	import org.springframework.stereotype.Component;
	@Entity
	@Component
	@Table (name="MYCART")
	public class Mycart 
	{
		@Id
		@Column(name="ID")
		private int id;
		
		@Column(name="USERID")
	    private String user_id;
		
		@Column(name="PRODUCTNAME")
		private String productname;
		
		@Column(name="PRICE")
		private double price;
		
		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Column(name="STATUS")
		private String status;
		
		@Column(name="QUANTITY")
		private int quantity;
		
		@Column(name="DATE_ADDED")
		private Date date_added;
		
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getProductname() {
			return productname;
		}

		public void setProductname(String productname) {
			this.productname = productname;
		}
		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public Date getDate_added() {
			return date_added;
		}

		public void setDate_added(Date date_added) {
			this.date_added = date_added;
		}
	}



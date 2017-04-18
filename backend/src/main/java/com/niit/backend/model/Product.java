package com.niit.backend.model;
import javax.persistence.Entity;


import javax .persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Table;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="PRODUCT")
@Component

public class Product {
	@Column(name="NAME")	
	private String name;
	@Id
    private String id;
	@Column(name="Category_ID")
	private String categoryid;
	@Column(name="Supplier_ID")
	private String supplierid;
	@Column(name="Price")
	private double price;
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name="Quantity")
	private String quantity;
	@javax.persistence.Transient
	MultipartFile pimage;
	public MultipartFile getPimage() {
		return pimage;
	}
	
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}
	public String getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(String supplierid) {
		this.supplierid = supplierid;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
}

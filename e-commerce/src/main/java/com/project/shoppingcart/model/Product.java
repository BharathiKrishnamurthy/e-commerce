package com.project.shoppingcart.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
    private Long product_id;
 
    @Basic(optional = false)
    private String productname;
 
    private Double price;
    
    public Product() {
    	//
    }

	public Product(Long id, String productname, Double price) {
		super();
		this.product_id = id;
		this.productname = productname;
		this.price = price;
	}

	
	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + product_id + ", productname=" + productname + ", price=" + price + "]";
	}
	
}

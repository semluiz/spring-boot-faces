package com.auth0.samples.bootfaces.controller;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private Long id;

	@Column
	private String name;

	@Column
	private BigDecimal price;

	protected  Product(){
	}

	public Product(String name, BigDecimal price){
		this.name = name;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}

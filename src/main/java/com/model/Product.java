package com.model;

public class Product {
	private String pname;
	private float price;
	private float ratings;
	private String description;
	public Product() {

	}
	public Product(String pname, float price, float ratings, String description) {
		this.pname = pname;
		this.price = price;
		this.ratings = ratings;
		this.description = description;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return pname+"     "+price+"       "+ratings+"       "+description;
	}
	
}

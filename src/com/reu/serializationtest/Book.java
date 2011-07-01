package com.reu.serializationtest;

import org.simpleframework.xml.Default;

@Default
public class Book {
	public enum Type {
		PAPERBACK, HARDCOVER, DIGITAL
	}
	private String title, author, description, image;
	private int numInStock;
	private double price;
	private Type type;
	private boolean onSale;
	
	public String getTitle() { return title; }
	
	public String getAuthor() { return author; }
	
	public String getDescription() { return description; }
	
	public String getImage() { return image; }
	
	public int getNumInStock() { return numInStock; }
	
	public double getPrice() { return price; }
	
	public Type getType() { return type; }
	
	public boolean getSale() { return onSale; }
	
	public void setTitle(String a) { title = a; }
	
	public void setAuthor(String a) { author = a; }
	
	public void setDescription(String a) { description = a; }
	
	public void setImage(String a) { image = a; }
	
	public void setNumInStock(int a) { numInStock = a; }
	
	public void setPrice(double a) { price = a; }
	
	public void setType(Type a) { type = a; }
	
	public void setSale(boolean a) { onSale = a; }
	
	@Override
	public String toString() {
		return String.format("Title: %s\nAuthor: %s\nDescription: %s\nImage: %s\nNumber In Stock: %d\nPrice: %f\nType: %s\nOn Sale: %b", title, author, description, image, numInStock, price, type, onSale);
	}
}

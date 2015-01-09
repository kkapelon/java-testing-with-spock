package com.manning.spock.chapter2.assets;

import java.math.BigDecimal;

public class CargoOrder {
	private String buyer;
	private String city;
	private BigDecimal price;
	
	
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	
}

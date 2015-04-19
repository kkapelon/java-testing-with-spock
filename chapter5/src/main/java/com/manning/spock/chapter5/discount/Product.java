package com.manning.spock.chapter5.discount;

public class Product {

	private boolean dailyDeal;
	private int discountPercent;
	private int price;
	public boolean isDailyDeal() {
		return dailyDeal;
	}
	public void setDailyDeal(boolean dailyDeal) {
		this.dailyDeal = dailyDeal;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}

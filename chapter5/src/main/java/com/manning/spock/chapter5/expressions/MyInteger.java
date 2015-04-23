package com.manning.spock.chapter5.expressions;

public enum MyInteger {
	ONE(1, "one"), TWO(2, "two"), THREE(3, "three"), FOUR(4, "four"), FIVE(5,
			"five"), SIX(6, "six"), SEVEN(7, "seven"), EIGHT(8, "eight"), NINE(
			9, "nine"), TEN(10, "ten");

	private int number;
	private String description;

	MyInteger(int number, String description) {
		this.number = number;
		this.description = description;
	}

	public int getNumber() {
		return number;
	}

	public String getDescription() {
		return description;
	}

}

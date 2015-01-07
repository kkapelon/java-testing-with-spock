package com.manning.spock.chapter2;

public class Stamper {

	private final AddressDao addressDao;

	public Stamper(AddressDao addressDao)
	{
		this.addressDao = addressDao;
	}
	
	public boolean isValid(Long addressID)
	{
		Address address = addressDao.load(addressID);
		return address.getStreet()!=null && address.getPostCode()!=null;
	}
}

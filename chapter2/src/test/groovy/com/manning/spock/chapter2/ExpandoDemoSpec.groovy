package com.manning.spock.chapter2

import spock.lang.*

class ExpandoDemoSpec extends spock.lang.Specification{
	
	def "Testing invalid address detection"() {
		when: "an address does not have a postcode"
		Address address = new Address(country:"Greece",number:23)
		
		def dummyAddressDao = new Expando()
		dummyAddressDao.load = { return address}
		
		Stamper stamper = new Stamper(dummyAddressDao as AddressDao)

		then: "this address is rejected"
		!stamper.isValid(1)
	}
	
	def "Testing invalid and valid address detection"() {
		when: "two different addresses are checked"
		Address invalidAddress = new Address(country:"Greece",number:23)
		Address validAddress = new Address(country:"Greece",number:23,street:"Argous", postCode:"4534")
		
		def dummyAddressDao = new Expando()
		dummyAddressDao.load = { id -> return id==2?validAddress:invalidAddress}
		
		Stamper stamper = new Stamper(dummyAddressDao as AddressDao)

		then: "Only the address with street and postcode is accepted"
		!stamper.isValid(1)
		stamper.isValid(2)
	}
	
}


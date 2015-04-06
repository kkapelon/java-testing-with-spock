package com.manning.spock.chapter1

import com.manning.spock.chapter1.billing.Client;
import com.manning.spock.chapter1.billing.CreditCardBilling;

import spock.lang.*


class BetterSpec extends spock.lang.Specification{
	def "Client should have a bonus if he spends more than 100 dollars"() {
		when: "a client buys something with value at least 100"
		def client = new Client();
		def billing = new CreditCardBilling();
		billing.charge(client,150);

		then: "Client should have the bonus option active"
		client.hasBonus() == true
	}
	
	def "Client loses bones is he does not accept the transaction"() {
		when: "a client buys something and later changes mind"
		def client = new Client();
		def billing = new CreditCardBilling();
		billing.charge(client,150);
		client.rejectsCharge();

		then: "Client should have the bonus option inactive"
		client.hasBonus() == false 
		
	}
}

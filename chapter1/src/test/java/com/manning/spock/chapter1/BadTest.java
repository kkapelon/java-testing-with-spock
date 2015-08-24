package com.manning.spock.chapter1;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import com.manning.spock.chapter1.billing.Client;
import com.manning.spock.chapter1.billing.CreditCardBilling;

public class BadTest {
	
	@Test
	public void scenario1() {
		CreditCardBilling billing = new CreditCardBilling();
		Client client = new Client();
		billing.charge(client,150);
		assertTrue("expect bonus",client.hasBonus());
	}
	
	@Test
	public void scenario2()	{
		CreditCardBilling billing = new CreditCardBilling();
		Client client = new Client();
		billing.charge(client,150);
		client.rejectsCharge();
		assertFalse("expect bonus",client.hasBonus());
	}

}

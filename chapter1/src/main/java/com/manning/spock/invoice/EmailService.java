package com.manning.spock.invoice;

public interface EmailService {
	void sendInvoice(Invoice invoice, String email);
}

package com.manning.spock.chapter8.helper

import spock.lang.*

import com.manning.spock.chapter8.loan.BankAccount
import com.manning.spock.chapter8.loan.CreditCard
import com.manning.spock.chapter8.loan.Customer
import com.manning.spock.chapter8.loan.Loan

class HelperMethodsSpec extends spock.lang.Specification{

	def "a bank customer with 3 credit cards is never given a loan"() {
		given: "a customer that wants to get a loan"
		Customer customer = new Customer(name:"John Doe")

		and: "his credit cards"
		BankAccount account1 = new BankAccount()
		account1.with {
			setNumber("234234")
			setHolder("John doe")
			balance=30
		}
		CreditCard card1 = new CreditCard("447978956666")
		card1.with{
			setHolder("John Doe")
			assign(account1)
		}
		customer.owns(card1)
		BankAccount account2 = new BankAccount()
		account2.with{
			setNumber("3435676")
			setHolder("John Doe")
			balance=30
		}
		CreditCard card2 = new CreditCard("4443543354")
		card2.with{
			setHolder("John Doe")
			assign(account2)
		}
		customer.owns(card2)
		BankAccount account3 = new BankAccount()
		account2.with{
			setNumber("45465")
			setHolder("John Doe")
			balance=30
		}
		CreditCard card3 = new CreditCard("444455556666")
		card3.with{
			setHolder("John Doe")
			assign(account3)
		}
		customer.owns(card3)

		when:"a loan is requested"
		Loan loan = new Loan()
		customer.requests(loan)

		then: "loan should not be approved"
		!loan.approved
	}
	
	def "a bank customer with 3 credit cards is never given a loan -alt"() {
		given: "a customer that wants to get a loan"
		Customer customer = new Customer(name:"John Doe")

		and: "his credit cards"
		customer.owns(createSampleCreditCard("447978956666","John Doe"))
		customer.owns(createSampleCreditCard("4443543354","John Doe"))
		customer.owns(createSampleCreditCard("444455556666","John Doe"))
		
		when:"a loan is requested"
		Loan loan = new Loan()
		customer.requests(loan)

		then: "loan should not be approved"
		!loan.approved
	}
	
	def "a bank customer with 3 credit cards is never given a loan -alt 2"() {
		given: "a customer that wants to get a loan"
		String customerName ="doesNotMatter"
		Customer customer = new Customer(name:customerName)

		and: "his credit cards"
		customer.owns(createSampleCreditCard("anything",customerName))
		customer.owns(createSampleCreditCard("whatever",customerName))
		customer.owns(createSampleCreditCard("notImportant",customerName))
		
		expect: "customer already has 3 cards"
		customer.getCards().size() == 3
		
		when:"a loan is requested"
		Loan loan = new Loan()
		customer.requests(loan)
		
		then: "therefore loan is not approved"
		!loan.approved
	}
	
	private CreditCard createSampleCreditCard(String number, String holder) {
		BankAccount account = new BankAccount()
		account.with{
			setNumber("45465")
			setHolder(holder)
			balance=30
		}
		CreditCard card = new CreditCard(number)
		card.with{
			setHolder(holder)
			assign(account)
		}
		return card
	}
}


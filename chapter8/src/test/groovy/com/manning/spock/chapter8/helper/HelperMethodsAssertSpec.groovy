package com.manning.spock.chapter8.helper

import spock.lang.*

import com.manning.spock.chapter8.loan.Customer
import com.manning.spock.chapter8.loan.Loan

class HelperMethodsAssertSpec extends spock.lang.Specification{

	def "Normal approval for a loan"() {
		given: "a bank customer"
		Customer customer = new Customer(name:"John Doe",city:"London",address:"10 Bakers",phone:"32434")

		and: "his/her need to buy a house "
		Loan loan = new Loan(years:5, amount:200.000)
	
		when:"a loan is requested"
		customer.requests(loan)

		then: "loan is approved as is"
		loan.approved
		loan.amount == 200.000
		loan.years == 5
		loan.instalments == 60
		loan.getContactDetails().getPhone() == "32434"
		loan.getContactDetails().getAddress() == "10 Bakers"
		loan.getContactDetails().getCity() == "London"
		loan.getContactDetails().getName() == "John Doe"
		customer.activeLoans == 1
		
	}
	
	def "Normal approval for a loan - alt"() {
		given: "a bank customer"
		Customer customer = new Customer(name:"John Doe",city:"London",address:"10 Bakers",phone:"32434")

		and: "his/her need to buy a house "
		int sampleTimeSpan=5
		int sampleAmount = 200.000
		Loan loan = new Loan(years:sampleTimeSpan, amount:sampleAmount)
	
		when:"a loan is requested"
		customer.requests(loan)

		then: "loan is approved as is"
		with(loan) {
			approved
			amount == sampleAmount
			years == sampleTimeSpan
			instalments == sampleTimeSpan * 12
		}
		customer.activeLoans == 1
		
		and: "contact details are kept or record"
		with(loan.contactDetails) {
			getPhone() == "32434"
			getAddress() == "10 Bakers"
			getCity() == "London"
			getName() == "John Doe"
		}
		
	}
	
	def "Normal approval for a loan - improved"() {
		given: "a bank customer"
		Customer customer = new Customer(name:"John Doe",city:"London",address:"10 Bakers",phone:"32434")

		and: "his/her need to buy a house "
		int sampleTimeSpan=5
		int sampleAmount = 200.000
		Loan loan = new Loan(years:sampleTimeSpan, amount:sampleAmount)
	
		when:"a loan is requested"
		customer.requests(loan)

		then: "loan is approved as is"
		loanApprovedAsRequested(customer,loan,sampleTimeSpan,sampleAmount)
		
		and: "contact details are kept or record"
		contactDetailsMatchCustomer(customer,loan)
	}
	
	private void loanApprovedAsRequested(Customer customer,Loan loan,int originalYears,int originalAmount) {
		with(loan) {
			approved
			amount == originalAmount
			loan.years == originalYears
			loan.instalments == originalYears * 12
		}
		assert customer.activeLoans == 1
	}
	
	private void contactDetailsMatchCustomer(Customer customer,Loan loan ) {
		with(loan.contactDetails) {
			phone == customer.phone
			address == customer.address
			city == customer.city
			name== customer.name
		}
	}
	
	
}


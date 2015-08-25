package com.manning.spock.chapter8.helper

import spock.lang.*

import com.manning.spock.chapter8.loan.ContactDetails
import com.manning.spock.chapter8.loan.Customer
import com.manning.spock.chapter8.loan.Loan

class HelperMethodsInteractSpec extends spock.lang.Specification{

	def "Normal approval for a loan"() {
		given: "a bank customer"
		Customer customer = new Customer(name:"John Doe",city:"London",address:"10 Bakers",phone:"32434")

		and: "his/her need to buy a house "
		Loan loan = Mock(Loan)
	
		when:"a loan is requested"
		customer.requests(loan)

		then: "loan is approved as is"
		1 * loan.setApproved(true)
		0 * loan.setAmount(_)
		0 * loan.setYears(_)
		_ * loan.getYears() >> 5
		_ * loan.getAmount() >> 200.000
		_ * loan.getContactDetails() >> new ContactDetails()
		
	}
	
	def "Normal approval for a loan - alt"() {
		given: "a bank customer"
		Customer customer = new Customer(name:"John Doe",city:"London",address:"10 Bakers",phone:"32434")

		and: "his/her need to buy a house "
		Loan loan = Mock(Loan)
	
		when:"a loan is requested"
		customer.requests(loan)

		then: "loan request was indeed evaluated"
		interaction {
			loanDetailsWereExamined(loan)
		}
		
		and: "loan was approved as is"
		interaction {
			loanWasApprovedWithNoChanges(loan)
		}
		
	}
	
	
	private void loanDetailsWereExamined(Loan loan) {
		_ * loan.getYears() >> 5
		_ * loan.getAmount() >> 200.000
		_ * loan.getContactDetails() >> new ContactDetails()
	}
	
	private void loanWasApprovedWithNoChanges(Loan loan) {
		1 * loan.setApproved(true)
		0 * loan.setAmount(_)
		0 * loan.setYears(_)
	}
	
	
}


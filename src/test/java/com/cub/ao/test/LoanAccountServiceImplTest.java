package com.cub.ao.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cub.ao.loan.service.LoanAccountService;
import com.cub.ao.loan.vo.LoanAccountResponse;
import com.cub.ao.loan.vo.LoanAccountTxnResponse;

public class LoanAccountServiceImplTest {/*
	@Autowired
	private LoanAccountService loanAccountService;
	private LoanAccountResponse expResult;
	private LoanAccountTxnResponse expResultTxn;
	private String customerId = "12345679";
	private String accountNumber = "0000806350410865";

	private LoanAccountResponse resp =  new LoanAccountResponse();
	private LoanAccountTxnResponse resptxn =  new LoanAccountTxnResponse();

	@Before
	public void initInputs() {
		System.out.println("initInputs");
		expResult = loanAccountService.getLoanAccountDetails(customerId, resp);
		expResultTxn = loanAccountService.getLoanAccountTxn(accountNumber, resptxn);
	}

	*//**
	 * Test case for checking the customer id is not null;
	 *//*
	@Test
	public void testCustomerId() {
		System.out.println("testCustomerId");
		assertNotNull(customerId);
	}

	*//**
	 * Test case for checking the account number is not null;
	 *//*
	@Test
	public void testAccountNumber() {
		System.out.println("testAccountNumber");
		assertNotNull(accountNumber);
	}
	
	
	 * Test case is for Loan Account details for particular customer.
	 
	@Test
	public void testGetLoanAccount() {

		System.out.println("GetLoanAccount");

		LoanAccountResponse result = loanAccountService.getLoanAccountDetails(
				customerId, resp);

		assertEquals("expected  Customer ID: ", expResult.getCustomerId(),
				result.getCustomerId());

		assertEquals("expected  Outstanding Total: ",
				expResult.getOutstandingTotal(), result.getOutstandingTotal());

		assertEquals("expected  Size of loanAccountList ", expResult
				.getLoanAccountList().size(), result.getLoanAccountList()
				.size());
	}
	
	
	 * Test case is for Loan Account Txn for particular customer.
	 
	@Test
	public void testGetLoanAccountTxn() {

		System.out.println("GetLoanAccount");

		LoanAccountTxnResponse result = loanAccountService.getLoanAccountTxn(
				accountNumber, resptxn);

		assertEquals("expected  Account Number: ", expResultTxn.getAccountNumber(),
				result.getAccountNumber());

		assertEquals("expected  Customer ID: ", expResultTxn.getLoanBalance(),
				result.getLoanBalance());
	}
	
*/}

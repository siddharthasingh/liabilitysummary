package com.cub.ao.loan.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author Niraja Deshpande
 * 
 */

public class LoanAccountVO implements Serializable {

	private static final long serialVersionUID = 545993571579708976L;

	private String accountType;
	private String loanAcctNbr;
	private String branchName;
	private String currencyCode;
	/*
	 * private BigDecimal currentPeriodPrincipalAmt; 
	 * private BigDecimal currentPeriodInterestAmt;
	 */
	private BigDecimal loanAmount;
	private BigDecimal outstandingLoanAmount;

	private String timestamp;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getLoanAcctNbr() {
		return loanAcctNbr;
	}

	public void setLoanAcctNbr(String loanAcctNbr) {
		this.loanAcctNbr = loanAcctNbr;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public BigDecimal getOutstandingLoanAmount() {
		return outstandingLoanAmount;
	}

	public void setOutstandingLoanAmount(BigDecimal outstandingLoanAmount) {
		this.outstandingLoanAmount = outstandingLoanAmount;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.cub.ao.loan.vo;

import java.math.BigDecimal;

public class LoanAccountTxnResponse {
	private String accountNumber;
	private BigDecimal loanAmount;
	private String loanType;
	private BigDecimal currentIntRate;
	private BigDecimal loanBalance;
	private String facilityStartDate;
	private String facilityEndDate;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public BigDecimal getCurrentIntRate() {
		return currentIntRate;
	}
	public void setCurrentIntRate(BigDecimal currentIntRate) {
		this.currentIntRate = currentIntRate;
	}
	public BigDecimal getLoanBalance() {
		return loanBalance;
	}
	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}
	public String getFacilityStartDate() {
		return facilityStartDate;
	}
	public void setFacilityStartDate(String facilityStartDate) {
		this.facilityStartDate = facilityStartDate;
	}
	public String getFacilityEndDate() {
		return facilityEndDate;
	}
	public void setFacilityEndDate(String facilityEndDate) {
		this.facilityEndDate = facilityEndDate;
	}
	
}

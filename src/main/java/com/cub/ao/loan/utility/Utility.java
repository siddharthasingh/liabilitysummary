package com.cub.ao.loan.utility;


/**
 * 
 * @author Niraja Deshpande
 * 
 */

public class Utility {/*
	private static final Logger LOGGER = LoggerFactory.getLogger(Utility.class);
	
	private Utility() {
	};

	
	public static void buildLoanTxnResponse(
			LoanTransaction loanTxn, LoanAccountTxnResponse resp) {
		if(null != loanTxn){
			resp.setAccountNumber(loanTxn.getAccountNumber());
			resp.setCurrentIntRate(loanTxn.getCurrentIntRate());
			DateFormat sqlDateFormat = new SimpleDateFormat("dd/MM/yyyy");
			if(null != loanTxn.getFacilityStartDate()){
				resp.setFacilityStartDate(sqlDateFormat.format(loanTxn.getFacilityStartDate()));
			}
			if(null != loanTxn.getFacilityEndDate()){
				resp.setFacilityEndDate(sqlDateFormat.format(loanTxn.getFacilityEndDate()));
			}
			resp.setLoanAmount(loanTxn.getLoanAmount());
			resp.setLoanBalance(loanTxn.getLoanBalance());
			int productCode = Integer.parseInt(loanTxn.getLoanType());
			if ((productCode >= 0000) && (productCode <= 4999)) {
				resp.setLoanType("Corporate Loan");
			} else if ((productCode >= 5000) && (productCode <= 9000)) {
				resp.setLoanType("Retail Loan");
			}
		}

	}
	public static LoanAccount buildLoanEntity(LiabilitySummaryVO liabilityVO) throws ParseException{
		LoanAccount loanEnt = null;
		try{
			loanEnt = new LoanAccount();
			SimpleDateFormat  dateFormat1 = new SimpleDateFormat("ddMMyyyy");
		//	loanEnt.setAcctTypeCode(liabilityVO.getAcctTypeCode());
		//	loanEnt.setAcctTypeCodeDesc(liabilityVO.getAcctTypeCodeDesc());
			loanEnt.setAcSyncTimestamp(liabilityVO.getAcSyncTimestamp());
			loanEnt.setAcUpdateTimestamp(liabilityVO.getAcUpdateTimestamp());
		//	loanEnt.setAuthorDrawingAccountNbr(liabilityVO.getAuthorDrawingAccountNbr());
			loanEnt.setBranchCode(liabilityVO.getBranchCode());
			loanEnt.setCurrencyCode(liabilityVO.getCurrencyCode());
			//loanEnt.setCurrencyCodeDesc(liabilityVO.getCurrencyCodeDesc());
			BigDecimal intRate = new BigDecimal(liabilityVO.getCurrentIntRate().trim().isEmpty()?"0":liabilityVO.getCurrentIntRate().trim());
			loanEnt.setCurrentIntRate(intRate);
			BigDecimal productSubCode = new BigDecimal(liabilityVO.getProductSubCode().trim().isEmpty()?"0":liabilityVO.getProductSubCode().trim());
			loanEnt.setProductSubCode(productSubCode);
			BigDecimal productTypeCode = new BigDecimal(liabilityVO.getProductTypeCode().trim().isEmpty()?"0":liabilityVO.getProductTypeCode().trim());
			loanEnt.setProductTypeCode(productTypeCode);
			BigDecimal loanType = new BigDecimal(liabilityVO.getLoanType().trim().isEmpty()?"0":liabilityVO.getLoanType().trim());
			loanEnt.setLoanType(loanType);
			
			loanEnt.setCustomerId(liabilityVO.getCustomerId().trim());
			BigDecimal facilityAmt = new BigDecimal(liabilityVO.getFacilityAmt().trim().isEmpty()?"0":liabilityVO.getFacilityAmt().trim());
			//facilityAmt = facilityAmt.movePointLeft(3);
			loanEnt.setFacilityAmt(facilityAmt);
			loanEnt.setFacilityNbr(liabilityVO.getFacilityNbr());
		//	BigDecimal currBalance = new BigDecimal(liabilityVO.getFxCurrentBal().isEmpty()?"0":liabilityVO.getFxCurrentBal());
		//	currBalance = currBalance.movePointLeft(3);
		//	loanEnt.setFxCurrentBal(currBalance);
			BigDecimal currIntAmt = new BigDecimal(liabilityVO.getCurrentPeriodInterestAmt().isEmpty()?"0":liabilityVO.getCurrentPeriodInterestAmt());
			currIntAmt = currIntAmt.movePointLeft(3);
			loanEnt.setCurrentPeriodInterestAmt(currIntAmt);
			BigDecimal currOthAmt = new BigDecimal(liabilityVO.getCurrentPeriodOtherAmt().isEmpty()?"0":liabilityVO.getCurrentPeriodOtherAmt());
			currOthAmt = currOthAmt.movePointLeft(3);
			loanEnt.setCurrentPeriodOtherAmt(currOthAmt);
			BigDecimal currPriAmt = new BigDecimal(liabilityVO.getCurrentPeriodPrincipalAmt().isEmpty()?"0":liabilityVO.getCurrentPeriodPrincipalAmt());
			currPriAmt = currPriAmt.movePointLeft(3);
			loanEnt.setCurrentPeriodPrincipalAmt(currPriAmt);
			BigDecimal currRepayAmt = new BigDecimal(liabilityVO.getCurrentPeriodRepaymentAmt().isEmpty()?"0":liabilityVO.getCurrentPeriodRepaymentAmt());
			currRepayAmt = currRepayAmt.movePointLeft(3);
			loanEnt.setCurrentPeriodRepaymentAmt(currRepayAmt);
			BigDecimal loanAmt = new BigDecimal(liabilityVO.getLoanAmount().trim().isEmpty()?"0":liabilityVO.getLoanAmount().trim());
			//loanAmt = loanAmt.movePointLeft(3);
			loanEnt.setLoanAmount(loanAmt);
			BigDecimal outLoanAmt = new BigDecimal(liabilityVO.getOutstandingLoanAmount().trim().isEmpty()?"0":liabilityVO.getOutstandingLoanAmount().trim());
			//outLoanAmt = outLoanAmt.movePointLeft(3);
			loanEnt.setOutstandingLoanAmount(outLoanAmt);
			
			loanEnt.setLoanAcctNbr(liabilityVO.getLoanAcctNbr());
			loanEnt.setProductCodeDesc(liabilityVO.getProductCodeDesc());
			
			
			if (null != liabilityVO.getFacilityEndDate() && liabilityVO.getFacilityEndDate().trim().length() != 0
					&& !liabilityVO.getFacilityEndDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(liabilityVO.getFacilityEndDate());
					loanEnt.setFacilityEndDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					loanEnt.setFacilityEndDate(null);
					LOGGER.warn(e.getMessage(),e);
				}						
			}
			if (null != liabilityVO.getFacilityStartDate() && liabilityVO.getFacilityStartDate().trim().length() != 0
					&& !liabilityVO.getFacilityStartDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(liabilityVO.getFacilityStartDate());
					loanEnt.setFacilityStartDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					loanEnt.setFacilityStartDate(null);
					LOGGER.warn(e.getMessage(),e);
				}						
			}
			if (null != liabilityVO.getLoanEndDate() && liabilityVO.getLoanEndDate().trim().length() != 0
					&& !liabilityVO.getLoanEndDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(liabilityVO.getLoanEndDate());
					loanEnt.setLoanEndDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					loanEnt.setLoanEndDate(null);
					LOGGER.warn(e.getMessage(),e);
				}						
			}
			if (null != liabilityVO.getLoanStartDate() && liabilityVO.getLoanStartDate().trim().length() != 0
					&& !liabilityVO.getLoanStartDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(liabilityVO.getLoanStartDate());
					loanEnt.setLoanStartDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					loanEnt.setLoanStartDate(null);
					LOGGER.warn(e.getMessage(),e);
				}						
			}
			if (null != liabilityVO.getNextPaymentDate() && liabilityVO.getNextPaymentDate().trim().length() != 0
					&& !liabilityVO.getNextPaymentDate().equals("99999999")) {
				try {
					java.util.Date parsed = dateFormat1.parse(liabilityVO.getNextPaymentDate());
					loanEnt.setNextPaymentDate(new java.sql.Date(parsed.getTime()));
				} catch (Exception e) {
					loanEnt.setNextPaymentDate(null);
					LOGGER.warn(e.getMessage(),e);
				}						
			}
		}catch(Exception e){
			LOGGER.info("Error in creating liability entity:",liabilityVO);
			LOGGER.error(e.getMessage(),e);
		}
		
		
		return loanEnt;
	}
	
	
*/}

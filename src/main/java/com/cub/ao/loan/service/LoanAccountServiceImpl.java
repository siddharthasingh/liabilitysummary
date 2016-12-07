package com.cub.ao.loan.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cub.ao.loan.vo.LoanAccountResponse;
import com.cub.ao.loan.vo.LoanAccountVO;

@Service
public class LoanAccountServiceImpl implements LoanAccountService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(LoanAccountServiceImpl.class);
	private static final String CLASS_NAME = LoanAccountServiceImpl.class.getName();
/*	@Autowired
	LoanDao loanDao;*/
	
	@Autowired
	private RestTemplate restTemplate;	
	
	@Value("${server.host}")
	private String hostname;
	
	@Value("${aointegration.port}")
	private String integrationPort;
	
	@Value("${aointegration.baseuri}")
	private String integrationBaseUri;
	
	@Value("${aointegration.sync.baseuri}")
	private String integrationSyncBaseUri;
	
	public LoanAccountResponse getLoanAccountDetails(String custId,
			LoanAccountResponse resp) {

		LOGGER.debug("Receive list of loan accounts");
		LoanAccountVO loanAcct = new LoanAccountVO();
		loanAcct.setAccountType("Home Loan");
		loanAcct.setBranchName("TCS - India");
		loanAcct.setCurrencyCode("INR");
		loanAcct.setLoanAmount(new BigDecimal(1200000));
		loanAcct.setOutstandingLoanAmount(new BigDecimal(8200));
		loanAcct.setLoanAcctNbr("L123450987");
		
		List<LoanAccountVO> loanAccountList = new ArrayList<>();
		loanAccountList.add(loanAcct);
		
		if (null != loanAccountList && !loanAccountList.isEmpty()) {
			resp.setCustomerId(custId);
			resp.setOutstandingTotal(new BigDecimal(8200));
			resp.setLoanAccountList(loanAccountList);
			
		}

		return resp;

	}
/*
	@Override
	public LoanAccountTxnResponse getLoanAccountTxn(String accntNo,
			LoanAccountTxnResponse resp) {
		LOGGER.debug("Fetching loan account txn for account number: " + accntNo);

		LoanTransaction loanTransaction = loanDao.getLoanAccountTxn(accntNo);

		if (null != loanTransaction) {

			LOGGER.debug("Build Loan Txn response");
			Utility.buildLoanTxnResponse(loanTransaction, resp);
		} else {
			throw new RecordNotFoundException("No Records Found");
		}

		return resp;

	}
	
	@Override
	public ResponseMessageVo getLiabilityAccountsList(String custId) {
		ResponseMessageVo responseMsg = new ResponseMessageVo();
		final String methodName = "getLiabilityAccountsList";
		LOGGER.debug(LiabilityConstants.LOG_ENTER_METHOD + methodName + LiabilityConstants.LOG_OF_CLASS + CLASS_NAME);
		List<String> accountList = null;
		Gson gson = new Gson();
		int updCount = 0;
		try {
			accountList = loanDao.getLoanAccountsList(custId);
			if(null != accountList && !accountList.isEmpty()){
				URI targetUrl = UriComponentsBuilder.fromUriString(integrationBaseUri).scheme("http").host(hostname).port(integrationPort).build().toUri();
				LOGGER.info("URI :: " + targetUrl);
				String [] str =  accountList.toArray(new String[accountList.size()]);
				AOUpdatedAccountsInfo aoData = restTemplate.postForObject(targetUrl, str, AOUpdatedAccountsInfo.class);
				if(null != aoData && null != aoData.getJsonAccountInfoList() ) {
					for(String dataList : aoData.getJsonAccountInfoList()) {
						LiabilitySummaryVO liabilityVO = gson.fromJson(dataList, LiabilitySummaryVO.class);
						LoanAccount liability = Utility.buildLoanEntity(liabilityVO);
						boolean loanUpdated = loanDao.saveUpdateBancsDetails(liability);
						if(loanUpdated) {
							updCount ++;
							sendDataForSync(liability.getLoanAcctNbr(),liability.getAcSyncTimestamp().toString());
						}
					}
					if(accountList.size() == updCount) {
						responseMsg.setMessageCode("S");
						responseMsg.setMessage("Update successful.");
					}
					
				}
				else if(null == aoData || null == aoData.getJsonAccountInfoList()) {
					responseMsg.setMessageCode("S");
					responseMsg.setMessage("No Data to Sync");
				} 
			}else{
				responseMsg.setMessageCode("S");
				responseMsg.setMessage("No Data to Sync");
			}
		} catch(Exception e){
			LOGGER.error(e.getMessage(), e);
			responseMsg.setMessageCode("F");
			responseMsg.setMessage("Update Failed");
		}
		return responseMsg;
	}
	

	public  void buildLiabilitySummaryResponse(
			List<LoanAccount> loanAccountList,LoanAccountResponse resp) {

		List<LoanAccountVO> loanAccountVOList = new ArrayList<LoanAccountVO>();
		LoanAccountVO loanAccountVO;
		BigDecimal outstandingTotal = new BigDecimal(0);

		for (LoanAccount loanSum : loanAccountList) {

			LOGGER.debug("Generate response in utility");
			loanAccountVO = new LoanAccountVO();
			if(null != loanSum.getProductTypeCode()){
				int productCode = loanSum.getProductTypeCode().intValueExact();
	
				if ((productCode >= 0000) && (productCode <= 4999)) {
					loanAccountVO.setAccountType("Corporate Loan");
				} else if ((productCode >= 5000) && (productCode <= 9000)) {
					loanAccountVO.setAccountType("Retail Loan");
				}
			}else{
				loanAccountVO.setAccountType("Loan Account");
			}
			loanAccountVO.setLoanAcctNbr(loanSum.getLoanAcctNbr());
			loanAccountVO.setBranchName(getBranchDetail(loanSum.getBranchCode()));
			loanAccountVO.setCurrencyCode(loanSum.getCurrencyCode());
			loanAccountVO.setLoanAmount(loanSum
					.getLoanAmount());
			loanAccountVO.setOutstandingLoanAmount(loanSum
					.getOutstandingLoanAmount());
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SSS");
			loanAccountVO.setTimestamp((dateFormat.format(timestamp)));
			DateFormat dateFormatInput = new SimpleDateFormat(
					"yyyyMMddHHmmssSS");
			try {
				Date date  = dateFormatInput.parse(loanSum.getAcSyncTimestamp());
				DateFormat dateFormat = new SimpleDateFormat(
						"dd/MM/yyyy HH:mm:ss.SS");
				//Timestamp timestamp = new Timestamp(dateFormat.);
				loanAccountVO.setTimestamp(dateFormat.format(date));
			} catch (ParseException e) {
				LOGGER.info("Error in parsing date"+loanSum.getAcSyncTimestamp());
			}
			outstandingTotal = outstandingTotal.add(loanAccountVO
					.getOutstandingLoanAmount());
			loanAccountVOList.add(loanAccountVO);
		}

		resp.setLoanAccountList(loanAccountVOList);
		LOGGER.debug("Generate outstanding total");
		resp.setOutstandingTotal(outstandingTotal);

	}
	
	public String getBranchDetail(String branchNo) {

		LOGGER.debug("Receive list of branch details");

		String branchName = null;

		BranchDetailsVO branchDetails = loanDao.getBranchCode(branchNo);
		if(null != branchDetails){
			branchName = branchDetails.getBranchName();
		}

		return branchName;

	}
	public void sendDataForSync(String accNo, String timeStamp){
		URI targetUrl = UriComponentsBuilder.fromUriString(integrationSyncBaseUri).scheme("http").host(hostname).port(integrationPort)
				.queryParam("accno", accNo).queryParam("time", timeStamp).build().toUri();
		LOGGER.debug("Calling URI: " + targetUrl);
		try{
			   ResponseEntity<String> resp= restTemplate.exchange(targetUrl, HttpMethod.GET, null, String.class);
			   resp.getBody();
		
		}catch (Exception ex){
			
				LOGGER.error(""+targetUrl,ex);
			
		}
	}


*/}

package com.cub.ao.loan.service;


/**
 * 
 * @author Niraja Deshpande
 *
 */


import org.springframework.stereotype.Service;

import com.cub.ao.loan.vo.LoanAccountResponse;
import com.cub.ao.loan.vo.LoanAccountTxnResponse;
import com.cub.ao.loan.vo.ResponseMessageVo;

@Service
public interface LoanAccountService {

	public LoanAccountResponse getLoanAccountDetails(String custId,
			LoanAccountResponse resp);
	/*public LoanAccountTxnResponse getLoanAccountTxn(String accntNo, 
			LoanAccountTxnResponse resp);
	public ResponseMessageVo getLiabilityAccountsList(String custId);
*/		
}

	

package com.cub.ao.loan.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cub.ao.loan.exception.LoanException;
import com.cub.ao.loan.exception.RecordNotFoundException;
import com.cub.ao.loan.service.LoanAccountServiceImpl;
import com.cub.ao.loan.vo.LoanAccountResponse;
import com.cub.ao.loan.vo.LoanAccountTxnResponse;
import com.cub.ao.loan.vo.ResponseMessageVo;



/**
 * 
 * @author Niraja Deshpande
 *
 */

@RestController
@RequestMapping("/loan")
public class LoanAccountController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoanAccountController.class);
	@Autowired(required=true)
	private LoanAccountServiceImpl loanAccountService;
	

	@RequestMapping(value="/summary", method = RequestMethod.GET)
	@ResponseBody
	public Object getAssetSummary( @RequestParam(value="customerId", required=false ) String customerId){
		LoanAccountResponse resp = new LoanAccountResponse();
		if (!StringUtils.isEmpty(customerId)) {
				try {
					LOGGER.info("Response of loan account");

					resp = loanAccountService.getLoanAccountDetails(customerId,
							resp);
				} catch (Exception e) {
					e.printStackTrace();
					throw new LoanException(e.getMessage());
				}

				if (null == resp.getLoanAccountList()
						|| resp.getLoanAccountList().isEmpty()) {

					throw new RecordNotFoundException("Records not found");
				}
		}
		else
		{
			throw new RecordNotFoundException("Please enter valid customer id.");
		}
		return resp;
	}
	
}

/*package com.cub.ao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.cub.ao.Application;
import com.cub.ao.model.LoanAccount;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class DepositControllerTest {

	final String BASE_URL = "http://localhost:8902/depositaccount";

	@Value("${local.server.port}")
	int port;

	@Test
	public void hasDepositAccount() {

		final long ACCOUNT_NO = 1010;
		final String BRANCH_NAME = "Pune";
		final String ACCOUNT_HOLDER_NAME = "Niraja";
		final long CURRENT_BALANCE = 50000;
		final long MATURITY_BALANCE = 65000;
		final String ACCOUNT_TYPE = "S";

		LoanAccount depoAcct = new LoanAccount();
		depoAcct.setAccountHolderName(ACCOUNT_HOLDER_NAME);
		depoAcct.setAccountNo(ACCOUNT_NO);
		depoAcct.setAccountType(ACCOUNT_TYPE);
		depoAcct.setBranchName(BRANCH_NAME);
		depoAcct.setCurrentBalance(CURRENT_BALANCE);
		depoAcct.setMaturityBalance(MATURITY_BALANCE);

		RestTemplate rest = new TestRestTemplate();

		ResponseEntity<LoanAccount> response = rest.postForEntity(BASE_URL,
				depoAcct, LoanAccount.class);

		LoanAccount depoAccount = response.getBody();
		assertThat(depoAccount.getAccountNo(), notNullValue());

		assertThat(depoAccount.getAccountHolderName(),
				equalTo(ACCOUNT_HOLDER_NAME));
		assertThat(depoAccount.getAccountType(), equalTo(ACCOUNT_TYPE));
		assertThat(depoAccount.getBranchName(), equalTo(BRANCH_NAME));

	}

}
*/
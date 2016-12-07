package com.cub.ao.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.cub.ao.loan.service.LiabilityKafkaService;
import com.cub.ao.loan.service.LoanAccountServiceImpl;


/**
 * 
 *
 */

@SpringBootApplication
public class Application { 
    public static void main(String[] args) {    	
    	ConfigurableApplicationContext context =  SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public LoanAccountServiceImpl loanAccountServiceImpl(){
        return new LoanAccountServiceImpl();
    }
    
    @Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
    
}

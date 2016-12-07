package com.cub.ao.loan.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cub.ao.loan.service.CurrencyRatesSyncService;

@EnableScheduling
@Component
public class CurrencyRatesSyncScheduler {/*
	private final Logger LOGGER = LoggerFactory.getLogger(CurrencyRatesSyncScheduler.class); 
	@Autowired
	CurrencyRatesSyncService currSyncService;
	@Scheduled(fixedDelayString="${currencyRatesSyncInterval}")
	public void syncCurrencyRates(){
		LOGGER.info("Scheduler starting to sync Current rates");
		currSyncService.syncCurrencyRates();
		LOGGER.info("Scheduler finished syncing Current rates");
	}
*/}

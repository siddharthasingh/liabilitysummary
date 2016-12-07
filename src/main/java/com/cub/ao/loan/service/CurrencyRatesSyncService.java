package com.cub.ao.loan.service;

import org.springframework.stereotype.Service;

@Service
public class CurrencyRatesSyncService {/*
	private final Logger LOGGER = LoggerFactory.getLogger(CurrencyRatesSyncService.class);
	@Value("${currServiceBaseURI}")
	String currServiceBaseURI;
	
	@Value("${currServicePath}")
	String currServicePath;
	
	@Value("${currSerivceHost}")
	String currSerivceHost;
	
	@Value("${currServicePort}")
	String currServicePort;
	
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	CurrencyRatesDao currRatesDao;
	*//**
	 * This method Currency Rates service and update latest currency rates in the database
	 *//*
	public void syncCurrencyRates(){
		List<CurrencyRatesVO> respList;
		URI targetUrl = UriComponentsBuilder.fromUriString(currServiceBaseURI).scheme("http").host(currSerivceHost).port(currServicePort)
				.path(currServicePath).build().toUri();
		try{
			ResponseEntity<List<CurrencyRatesVO>> currRatesResp =
			        restTemplate.exchange(targetUrl,
			                    HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrencyRatesVO>>() {
			            });
			respList = currRatesResp.getBody();
			if(null != respList && !respList.isEmpty()){
				for(CurrencyRatesVO currRatesVO: respList){
					CurrencyRatesEntity entity = buildCurrencyRatesEntity(currRatesVO);
					if(null != entity){
						currRatesDao.syncCurrencyRates(entity);
					}else{
						throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "There is no entity to update database");
					}
				}
			}else{
				throw new HttpClientErrorException(HttpStatus.NOT_FOUND, "There is no response from Currency Service ");
			}
		}catch(Exception ex){
			LOGGER.error(ex.getMessage(),ex);
			throw ex;
		}
	}
	private CurrencyRatesEntity buildCurrencyRatesEntity(
			CurrencyRatesVO currRatesVO) {
		CurrencyRatesEntity entity = null;
		if(null != currRatesVO){
			entity = new CurrencyRatesEntity();
			entity.setCurrencyCode(currRatesVO.getCcy());
			entity.setCurrencyTwdEquivalent(currRatesVO.getExrateFixed());
			entity.setLastUpdateTimestamp(currRatesVO.getLastUpdateTime());
		}
		
		return entity;
	}
*/}

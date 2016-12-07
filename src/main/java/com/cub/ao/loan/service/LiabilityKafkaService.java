package com.cub.ao.loan.service;

import org.springframework.stereotype.Service;

@Service
public class LiabilityKafkaService {/*
	
	@Autowired
	LoanDao loanDao;
	
	@Autowired
	PollableChannel fromKafka;
	@Autowired
	KafkaProducerMessageHandler<String,String> aomdKafkaHandler;

	
	@Value("${liability.offset.db.key}")
	private String offsetDbKey;
	
	
	private static long liabilityOffset;
	private static int kafkaExecCount;
	private static final Logger LOGGER = LoggerFactory.getLogger(LiabilityKafkaService.class);
	
	public void getMessagesFromKafka() {
		Gson gson = new Gson();
		
		LOGGER.info("Getting msg from Kafka");
		try {
			Message<?> received = fromKafka.receive();
			LiabilitySummaryVO liabilityVO=null;
			while (true) {
				try {				
					if(received != null) {
						liabilityOffset = (Long) received.getHeaders().get("kafka_offset");
						
						liabilityVO = gson.fromJson(received.getPayload().toString(), LiabilitySummaryVO.class);
						LoanAccount loanEntity = Utility.buildLoanEntity(liabilityVO);
						if(null != loanEntity){
							boolean loanUpdated = loanDao.saveUpdateBancsDetails(loanEntity);
							if(loanUpdated) {
								sendToKafkaForSync(liabilityVO.getLoanAcctNbr(),liabilityVO.getAcSyncTimestamp().toString());
							}
						}
						kafkaExecCount++;
						if(kafkaExecCount % 100==0){
							commitKafkaOffset();
							kafkaExecCount=0;
						}
					}
					
				} catch (Exception e) {
					LOGGER.error("Error while processing kafka receive : "  ,liabilityVO);
					LOGGER.error(e.getMessage() ,e);
				}
				received = fromKafka.receive();
			}
			
		} catch (Exception e) {
			LOGGER.error("Error in getMessagesFromKafka()", e.getMessage());
		}				
	}
	
	private void sendToKafkaForSync(String accountNo, String acSyncTimestamp) {
		String messageToSend = acSyncTimestamp + "," + accountNo;
		Message<String> message = MessageBuilder.withPayload(messageToSend).build();
		LOGGER.info("Sending message to kafka for sync"+message);
		aomdKafkaHandler.handleMessage(message);
	}
	
	@PostConstruct
	public void init(){
		liabilityOffset = loanDao.getLiabilityOffset();
	}
	@PreDestroy
	public void updateOffsetValue() {
		commitKafkaOffset();
	}
	
	private void commitKafkaOffset(){
		AoProperties aoPropObj = new AoProperties();
		aoPropObj.setPropertyName(offsetDbKey);
		aoPropObj.setPropertyValue(String.valueOf(liabilityOffset ));
		loanDao.updateLiabilityOffset(aoPropObj);
	}
	
*/}

package com.cub.ao.loan.utility;


import org.springframework.context.annotation.Configuration;
import org.springframework.integration.config.EnableIntegration;
@EnableIntegration
@Configuration
public class KafkaConfig {/*
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);
	@Value("${kafka.topic.liability}")
	private String liabilityTopic;
	
	@Value("${kafka.topic.aomd}")
	private String aomdTopic;

	@Value("${kafka.broker.address}")
	private String brokerAddress;
	
	@Autowired
	LoanDao liabilityDao;
	
	@Autowired
	KafkaMessageDrivenChannelAdapter<String, String> channelAdapter;
	
	
	@ServiceActivator(inputChannel = "toAomdKafka")
	@Bean(name="aomdKafkaHandler")
	public KafkaProducerMessageHandler<String, String> handler() throws Exception {
		KafkaProducerMessageHandler<String, String> handler =
				new KafkaProducerMessageHandler<>(kafkaTemplate());
		handler.setTopicExpression(new LiteralExpression(this.aomdTopic));
		return handler;
	}
		
	@Bean
	public KafkaMessageListenerContainer<String, String> container() throws Exception {
		Long offsetVal = liabilityDao.getLiabilityOffset();
		return new KafkaMessageListenerContainer<>(consumerFactory(),
				new ContainerProperties(new TopicPartitionInitialOffset(this.liabilityTopic, 0, offsetVal+1)));
	}
	
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "ao_liability_grp");
		props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
		props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 100);
		props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, 15000);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
		//props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");		
		return new DefaultKafkaConsumerFactory<>(props);
	}
	
	@Bean
	public KafkaMessageDrivenChannelAdapter<String, String>
				adapter(KafkaMessageListenerContainer<String, String> container) {
		KafkaMessageDrivenChannelAdapter<String, String> kafkaMessageDrivenChannelAdapter =
				new KafkaMessageDrivenChannelAdapter<>(container);
		kafkaMessageDrivenChannelAdapter.setOutputChannel(received());
		return kafkaMessageDrivenChannelAdapter;
	}
	
	@Bean(name="fromKafka")
	public PollableChannel received() {
		return new QueueChannel();
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.brokerAddress);
		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return new DefaultKafkaProducerFactory<>(props);
	}
	
	
*/}

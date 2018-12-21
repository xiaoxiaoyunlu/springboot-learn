package oz.mano.online.config;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import oz.mano.online.mq.Gson2JsonMessageConverter;
import oz.mano.online.mq.MqQueueType;

@Configuration
public class MQConfig {
	
	@Value("${spring.rabbit.exchange}")
	private String exchange;
	
	@Value("${spring.rabbitmq.host}")
	private String host;
	
	@Value("${spring.rabbitmq.port}")
	private int port;
	
	@Value("${spring.rabbitmq.username}")
	private String username;
	
	@Value("${spring.rabbitmq.password}")
	private String password;
	
	@Value("${spring.rabbitmq.virtual-host}")
	private String vhost;
	
	@Value("${spring.rabbitmq.publisher-confirms}")
	private boolean publisher_confirms;
	
	/**
     * 配置链接信息
     * @return
     */
	@Bean
	public ConnectionFactory connectionFactory(){
        CachingConnectionFactory connectionFactory=new CachingConnectionFactory(host, port);
        connectionFactory.setUsername(username);
        connectionFactory.setPassword(password);
        connectionFactory.setVirtualHost(vhost);
        connectionFactory.setPublisherConfirms(publisher_confirms);  //必须设置？
        return connectionFactory;
	}
	
	@Bean
	public MessageConverter customConverter(){
		return new Gson2JsonMessageConverter();
	}
	
	@Bean
    public RabbitTemplate rabbitTemplateDirect(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(customConverter());
//        template.setExchange(MqQueueType.MQ_EXCHANGE_DIRECT.getName());
//        template.setMandatory(true);   //开启手动ack
        return template;
    }
	
//	@Bean
//    public RabbitTemplate rabbitTemplateDelay(ConnectionFactory connectionFactory) {
//        RabbitTemplate template = new RabbitTemplate(connectionFactory);
//        template.setMessageConverter(new Gson2JsonMessageConverter());
//        template.setExchange(MqQueueType.MQ_EXCHANGE_DEAD_LETTER.getName());
//        return template;
//    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMessageConverter(new Gson2JsonMessageConverter());
        return factory;
    }
    
    @Bean
    public Exchange directExchange(){
    	Exchange directExchange = ExchangeBuilder.directExchange(MqQueueType.MQ_EXCHANGE_DIRECT.getName()).durable(true).build();
    	return directExchange;
    }
    
    @Bean
    public Exchange deadLetterExchange(){
    	Exchange directExchange = ExchangeBuilder.directExchange(MqQueueType.MQ_EXCHANGE_DEAD_LETTER.getName()).durable(true).build();
    	return directExchange;
    }
    
    /**
     * 物流队列
     * @return
     */
    @Bean
    public Queue queueLogistics(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_LOGISTICS.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(directExchange()).with(MqQueueType.MQ_QUEUE_LOGISTICS.getName());
    	return queue;
    }
    
    /**
     * 推送队列
     * @return
     */
    @Bean
    public Queue queuePush(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_PUSH.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(directExchange()).with(MqQueueType.MQ_QUEUE_PUSH.getName());
    	return queue;
    }
    
    /**
     * 支付队列
     * @return
     */
    @Bean
    public Queue queueOrderPay(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_ORDER.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(directExchange());
    	return queue;
    }
    
    /**
     * 优惠券队列
     * @return
     */
    @Bean
    public Queue queueDiscount(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_DISCOUNT.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(directExchange());
    	return queue;
    }
    
    /**
     * 推送备用队列
     * @return
     */
    @Bean
    public Queue queuePushBak(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_PUSH_BAK.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(directExchange());
    	return queue;
    }
    
    @Bean
    public Queue queueOrderDelay30m(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_ORDER_DELAY_30M.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(deadLetterExchange()).with(MqQueueType.MQ_QUEUE_ORDER_DELAY_30M.getName()).noargs();
    	return queue;
    }
    
    @Bean
    public Queue queueDiscountDelay30m(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_DISCOUNT_DELAY_30M.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(deadLetterExchange()).with(MqQueueType.MQ_QUEUE_DISCOUNT_DELAY_30M.getName()).noargs();
    	return queue;
    }
    
    @Bean Queue queuePushDelay(){
    	Queue queue = new Queue(MqQueueType.MQ_QUEUE_PUSH_DELAY.getName(), true, false, false);
    	BindingBuilder.bind(queue).to(deadLetterExchange()).with(MqQueueType.MQ_QUEUE_PUSH_DELAY.getName()).noargs();
    	return queue;
    }
    

}

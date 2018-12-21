package oz.mano.online.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TestConsumer {
	
	@RabbitHandler
	@RabbitListener(queues="queue.push.bak", containerFactory="rabbitListenerContainerFactory")
	public void testPushConsume(@Payload PushMsg pushMsg){
		System.out.println("result"+pushMsg);
	}
	

	@RabbitHandler
	@RabbitListener(queues="queue.order", containerFactory="rabbitListenerContainerFactory")
	public void testOrderConsumer(String order_id){
		System.out.println("result"+order_id);
		
	}
}

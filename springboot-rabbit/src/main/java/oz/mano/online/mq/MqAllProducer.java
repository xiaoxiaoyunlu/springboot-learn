package oz.mano.online.mq;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqAllProducer extends AbstractMQProducer {

	@Autowired 
	private RabbitTemplate rabbitTemplate;

	@Override
	public void doSendMqMsg(MqMsg mqMsg) {
		try {
			rabbitTemplate.convertAndSend(mqMsg.getRouteKey(), mqMsg.getMsg());
			System.out.println("mq send success");
		} catch (Exception e) {
			e.printStackTrace();
			//补偿
			MsgQueueMaster.getInstance().sendPushMsg(mqMsg);
		}
		
	}

	@Override
	public void doSendMqMsgDelay(MqMsg mqMsg) {
		try {
			rabbitTemplate.convertAndSend(mqMsg.getRouteKey(),mqMsg.getMsg(),new MessagePostProcessor() {				
				@Override
				public Message postProcessMessage(Message message) throws AmqpException {
					message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
					message.getMessageProperties().setExpiration("20000");
//					message.getMessageProperties().setDelay(1000);
					return message;
				}
			});
			System.out.println("mq mutril send success");
			
		} catch (Exception e) {
			e.printStackTrace();
			//补偿
			MsgQueueMaster.getInstance().sendPushMsg(mqMsg);
		}
		
	}
}

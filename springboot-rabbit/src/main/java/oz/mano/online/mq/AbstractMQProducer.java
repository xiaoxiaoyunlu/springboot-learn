package oz.mano.online.mq;

import oz.mano.online.common.Code;
import oz.mano.online.exception.LogicException;
import oz.mano.online.utils.StringUtil;

public abstract class AbstractMQProducer {
	
	protected void send(MqMsg mqMsg) {
		Object obj = mqMsg.getMsg();
		if(obj instanceof PushMsg){
			PushMsg pushMsg=(PushMsg)obj;
			if(StringUtil.INSTANCE.isEmpty(pushMsg.getMsg_time_set())){
				doSendMqMsg(mqMsg);
			}else {
				doSendMqMsgDelay(mqMsg);
			}
		}else {
		   throw new LogicException(Code.MQ_BODY_PUSH_NULL.getCode(),Code.MQ_BODY_PUSH_NULL.getMessage());	
		}
	}
	
	public abstract void doSendMqMsg(MqMsg mqMsg);
	
	public abstract void doSendMqMsgDelay(MqMsg mqMsg);

}

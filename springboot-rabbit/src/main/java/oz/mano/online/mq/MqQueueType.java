package oz.mano.online.mq;

public enum MqQueueType {
	
	MQ_QUEUE_ORDER("queue.order","订单"),
	MQ_QUEUE_ORDER_DELAY_30M("queue.order.delay.30m","订单支付延迟30分钟"),
	MQ_QUEUE_LOGISTICS("queue.logistics","物流"),
	MQ_QUEUE_PUSH("queue.push","推送"),
	MQ_QUEUE_PUSH_DELAY("queue.push.delay","推送延迟"),
	MQ_QUEUE_DISCOUNT("queue.discount","优惠券"),
	MQ_QUEUE_DISCOUNT_DELAY_30M("queue.discount.delay.30m","优惠券 延迟时间"),
	MQ_QUEUE_PUSH_BAK("queue.push.bak","推送发送"),
	MQ_QUEUE_DEAD_LETTER("queue.dead.letter","死信队列"),
	MQ_QUEUE_DEAD_LETTER_CACHE("queue.dead.letter.cache","缓冲队列"),
	
	MQ_TEMPLATE_DIRECT("mano.direct","直连模板"),
	MQ_TEMPLATE_DEAD_LETTER("mano.dead.letter","死信模板"),
	
	
	MQ_EXCHANGE_DIRECT("mano.direct","直连交换机"),
	MQ_EXCHANGE_DEAD_LETTER("mano.dead.letter","死信交换机"),
	
	;
	
	private MqQueueType(String name, String msg) {
		this.name = name;
		this.msg = msg;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	private String name;
	private String msg;

}

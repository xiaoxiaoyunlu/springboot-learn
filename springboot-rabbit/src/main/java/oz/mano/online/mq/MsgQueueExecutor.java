package oz.mano.online.mq;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 原来作为推送消息 
 * 现在作为  MQ备用发送队列
 * @author USER
 *
 */
public class MsgQueueExecutor implements Runnable {
	
	private MqAllProducer mqAllProducer;
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MsgQueueExecutor.class);

	protected AtomicLong queueIn = new AtomicLong(0);
	protected AtomicLong queueOut = new AtomicLong(0);
	protected ConcurrentLinkedQueue<MqMsg> mq = new ConcurrentLinkedQueue<MqMsg>();
	private boolean stoped = false;

	@Override
	public void run() {
		while (!this.stoped) {
			try {
				processMsg();
			} catch (Exception e) {
				e.printStackTrace();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
	}

	public void stop() {
		this.stoped = true;
	}

	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	private void processMsg() {
		MqMsg msg = receive();
		if (msg != null) {
			LOGGER.info("MsgQueueExecutor 执行了......");
			try {
				mqAllProducer.doSendMqMsg(msg);
			} catch (Exception e) {
				LOGGER.error("error:", e);
				try {
					send(msg);  //放入队列下次尝试
					Thread.sleep(2000);
				} catch (InterruptedException ex) {
					LOGGER.error("error:", ex);
				}
			}
		} else {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				LOGGER.error("error:", e);
			}
		}
	}

	private boolean enqueue(MqMsg pushMsg) {
		boolean result = mq.add(pushMsg);
		if (result == true) {
			queueIn.addAndGet(1);
		}
		return result;
	}

	private MqMsg dequeue() {
		MqMsg m = mq.poll();
		if (m != null) {
			queueOut.addAndGet(1);
		}
		return m;
	}

	private MqMsg receive() {
		return dequeue();
	}

	public boolean send(MqMsg pushMsg) {
		return enqueue(pushMsg);
	}
	
	public void setMqAllProducer(MqAllProducer mqAllProducer) {
		this.mqAllProducer = mqAllProducer;
	}
}

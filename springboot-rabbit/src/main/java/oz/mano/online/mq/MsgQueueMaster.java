package oz.mano.online.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MsgQueueMaster {
	public MsgQueueExecutor getExecutorPush() {
		return executorPush;
	}

	public void setExecutorPush(MsgQueueExecutor executorPush) {
		this.executorPush = executorPush;
	}

	private static final Logger LOGGER = LoggerFactory
			.getLogger(MsgQueueMaster.class);

	private static MsgQueueMaster instance;
	
	private MsgQueueExecutor executorPush;
	protected Thread executorPushThread;
	
//	private static KuaiDiQueueExecutor executorKuaiDi;
//	protected Thread executorKuaiDiThread;

	public static MsgQueueMaster getInstance() {
		if (null == instance) {
			synchronized (MsgQueueMaster.class) {
				if (null == instance) {
					instance = new MsgQueueMaster();
				}
			}
		}
		return instance;
	}

	public void start() throws Exception {
		initPushMsgQueue();
//		initKuaiDiQueue();
	}
	
	public void initPushMsgQueue()throws Exception{
		this.executorPush = new MsgQueueExecutor();
		executorPushThread = new Thread(executorPush, "MsgQueueExecutor-thread");
		executorPushThread.start();
		LOGGER.info("MsgQueueExecutor-thread 启动了........");
	}
	
//	public void initKuaiDiQueue()throws Exception{
//		this.executorKuaiDi=new KuaiDiQueueExecutor();
//		executorKuaiDiThread=new Thread(executorKuaiDi,"KuaiDiQueueExecutor-thread");
//		executorKuaiDiThread.start();
//		LOGGER.info("KuaiDiQueueExecutor-thread 启动了........");
//	}

	public void stop() throws Exception {
		executorPush.stop();
//		executorKuaiDi.stop();
		try {
			executorPushThread.join();
//			executorKuaiDiThread.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean sendPushMsg(MqMsg message) {
		return executorPush.send(message);
	}
	
//	public boolean sendKuaiDiRequest(TaskRequest request) {
//		return executorKuaiDi.send(request);
//	}

}

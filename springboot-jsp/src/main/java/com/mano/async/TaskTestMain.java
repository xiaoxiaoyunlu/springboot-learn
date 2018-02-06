package com.mano.async;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TaskTestMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				TaskExecutorConfig.class);

		TaskService taskService = context.getBean(TaskService.class);

		for (int i = 0; i < 3; i++) {
			taskService.executeAsyncTask(i);
			taskService.executeAsyncTaskPlus(i);
		}
		context.close();
	}

}

package com.mano.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EventTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				EventConfig.class);

		DemoPublisher publisher = context.getBean(DemoPublisher.class);
		publisher.publish("nihao world");

		context.close();
	}
}

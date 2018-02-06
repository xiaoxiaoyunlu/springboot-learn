package com.mano.schedule;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScheduledTestMain {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				TaskScheduledConfig.class);

	}

}

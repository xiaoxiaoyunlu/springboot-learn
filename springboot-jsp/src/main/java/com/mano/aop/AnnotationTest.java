package com.mano.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AopConfig.class);
		UserService userService = context.getBean(UserService.class);
		UserMethodService userMethodService = context
				.getBean(UserMethodService.class);
		userService.add();
		userMethodService.add();
		context.close();
	}

}

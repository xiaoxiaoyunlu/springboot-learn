package com.mano.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * 可以通过设定jvm参数   spring.profiles.active参数来设定环境配置
 * spring.profiles.active=dev
 */

public class ProfileTestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("dev");
		context.register(ProfileConfig.class);
		context.refresh();

		ProfileBean profileBean = context.getBean(ProfileBean.class);

		System.out.println(profileBean.getContent());

		context.close();

	}

}

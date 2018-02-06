package com.mano.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileConfig {

	@Bean
	@Profile("dev")
	public ProfileBean devDemoBean() {
		return new ProfileBean("from dev profile");
	}

	@Bean
	@Profile("prod")
	public ProfileBean proDemoBean() {
		return new ProfileBean("from prod profile");
	}
}

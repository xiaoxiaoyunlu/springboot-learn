package com.mano.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfig {

	@Bean
	@Conditional(WindowConditon.class)
	public ListService windowListService() {
		return new WindowListService();
	}

	@Bean
	@Conditional(LinuxConditon.class)
	public ListService linuxListService() {
		return new LinuxListService();
	}

}

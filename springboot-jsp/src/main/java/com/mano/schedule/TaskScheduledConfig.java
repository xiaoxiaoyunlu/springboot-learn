package com.mano.schedule;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.mano.schedule")
@EnableScheduling
public class TaskScheduledConfig {

}

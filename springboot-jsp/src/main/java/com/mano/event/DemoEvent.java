package com.mano.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(DemoEvent.class);

	private String msg;

	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}

package com.mano.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

	@Override
	public void onApplicationEvent(DemoEvent event) {

		String msg = event.getMsg();
		System.out.println("我（DemoListener）接受到了" + msg);
	}

}

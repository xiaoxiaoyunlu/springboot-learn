package com.mano.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduleSergice {

	private static final SimpleDateFormat dateformat = new SimpleDateFormat(
			"HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		System.out.println("每隔五秒执行一次：" + dateformat.format(new Date()));
	}

	@Scheduled(cron = "0 27 16 * * *")
	public void fixTimeExecute() {
		System.out.println("指定时间" + dateformat.format(new Date()) + "执行");
	}
}

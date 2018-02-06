package com.mano.combo_anno;

import org.springframework.stereotype.Service;

@Service
public class ComboDemoService {

	public void outPutResult() {
		System.out.println("从组合注解配置照样获得bean");
	}
}

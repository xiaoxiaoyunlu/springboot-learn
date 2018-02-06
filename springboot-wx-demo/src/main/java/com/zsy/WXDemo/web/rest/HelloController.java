package com.zsy.WXDemo.web.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@RequestMapping("/getMessage")
	public void getMessage(){
		System.out.println("11111111111");
	}

}

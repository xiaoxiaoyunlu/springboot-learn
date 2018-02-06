package com.mano.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/")
	public String index(Map<String, Object> map) {
		return "index";

	}

	@RequestMapping("/login")
	public String login(Map<String, Object> map) {
		return "login";

	}
}

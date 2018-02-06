package com.zsy.WXDemo.domain.wx;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class CreateMenu {

	@JSONField(name="button")
	private List<MenuOne> buttons;

	public List<MenuOne> getButtons() {
		return buttons;
	}

	public void setButtons(List<MenuOne> buttons) {
		this.buttons = buttons;
	}
	
}

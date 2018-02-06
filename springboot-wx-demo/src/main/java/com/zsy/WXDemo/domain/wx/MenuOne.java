package com.zsy.WXDemo.domain.wx;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class MenuOne {

	@JSONField(name="type")
	private String type;
	@JSONField(name="url")
	private String url;
	@JSONField(name="name")
	private String name;
	@JSONField(name="key")
	private String key;
	@JSONField(name="sub_button")
	private List<MenuTwo> sub_button;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public List<MenuTwo> getSub_button() {
		return sub_button;
	}
	public void setSub_button(List<MenuTwo> sub_button) {
		this.sub_button = sub_button;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}

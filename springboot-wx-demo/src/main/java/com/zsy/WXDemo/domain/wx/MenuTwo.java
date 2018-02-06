package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;


public class MenuTwo  {

	@JSONField(name="type")
	private String type;
	@JSONField(name="name")
	private String name;
	@JSONField(name="key")
	private String key;
	@JSONField(name="url")
	private String url;
	@JSONField(name="appid")
	private String appid;     //小程序
	@JSONField(name="pagepath")
	private String pagepath;
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
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPagepath() {
		return pagepath;
	}
	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

}

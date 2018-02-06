package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class WeiXinQRCode {
	
	@JSONField(name="expire_seconds")
	private Long expire_seconds;
	@JSONField(name="action_name")
	private String action_name;
	@JSONField(name="action_info")
	private WeiXinActionInfo action_info;
	@JSONField(name="ticket")
	private String ticket;
	@JSONField(name="url")
	private String url;
	
	public Long getExpire_seconds() {
		return expire_seconds;
	}
	public void setExpire_seconds(Long expire_seconds) {
		this.expire_seconds = expire_seconds;
	}
	public String getAction_name() {
		return action_name;
	}
	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}
	public WeiXinActionInfo getAction_info() {
		return action_info;
	}
	public void setAction_info(WeiXinActionInfo action_info) {
		this.action_info = action_info;
	}
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}

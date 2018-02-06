package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class WxCheck {
	
	@JSONField(name="signature")
	private String signature ;
	
	@JSONField(name="timestamp")
	private String timestamp;
	
	@JSONField(name="nonce")
	private String nonce;
	
	@JSONField(name="echostr")
	private String echostr;
	
	@JSONField(name="token")
	private String token;

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNonce() {
		return nonce;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

	public String getEchostr() {
		return echostr;
	}

	public void setEchostr(String echostr) {
		this.echostr = echostr;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}

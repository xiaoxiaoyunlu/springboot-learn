package com.zsy.WXDemo.domain.db;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	
	private Long id;
	@JSONField(name="openid")
	private String open_id;
	@JSONField(name="nickname")
	private String user_name;
	@JSONField(name="phone")
	private String phone;
	@JSONField(name="address")
	private String address;
	@JSONField(name="type")
	private Integer type;
	@JSONField(name="count")
	private Integer count;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOpen_id() {
		return open_id;
	}
	public void setOpen_id(String open_id) {
		this.open_id = open_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

}

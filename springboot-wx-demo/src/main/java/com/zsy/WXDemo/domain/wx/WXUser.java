package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class WXUser {
	
	@JSONField(name="openid")
	private String openid;
	
	@JSONField(name="nickname")
	private String nickname;
	
	@JSONField(name="sex")
	private Integer sex;
	
	@JSONField(name="province")
	private String province;
	
	@JSONField(name="city")
	private String city;
	
	@JSONField(name="country")
	private String country;
	
	@JSONField(name="headimgurl")
	private String headimgurl;
	
	@JSONField(name="unionid")
	private String unionid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHeadimgurl() {
		return headimgurl;
	}

	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}

	public String getUnionid() {
		return unionid;
	}

	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
}

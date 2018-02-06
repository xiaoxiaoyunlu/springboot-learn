package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class WeiXinScene {
	
	@JSONField(name="scene_id")
	private  Integer scene_id;
	@JSONField(name="scene_str")
	private String scene_str;
	public String getScene_str() {
		return scene_str;
	}
	public void setScene_str(String scene_str) {
		this.scene_str = scene_str;
	}
	public Integer getScene_id() {
		return scene_id;
	}
	public void setScene_id(Integer scene_id) {
		this.scene_id = scene_id;
	}

}

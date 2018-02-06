package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class WeiXinActionInfo {
	
	@JSONField(name="scene")
	private WeiXinScene scene;

	public WeiXinScene getScene() {
		return scene;
	}

	public void setScene(WeiXinScene scene) {
		this.scene = scene;
	}

}

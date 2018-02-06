package com.zsy.WXDemo.domain.wx;

import com.alibaba.fastjson.annotation.JSONField;

public class AccessToken {    
    // 获取到的凭证  
	@JSONField(name="access_token")
    private String token;    
    // 凭证有效时间，单位：秒    
	@JSONField(name="expires_in")
    private int expiresIn;  
      
    public String getToken() {  
        return token;  
    }  
    public void setToken(String token) {  
        this.token = token;  
    }  
    public int getExpiresIn() {  
        return expiresIn;  
    }  
    public void setExpiresIn(int expiresIn) {  
        this.expiresIn = expiresIn;  
    }  
  
}  
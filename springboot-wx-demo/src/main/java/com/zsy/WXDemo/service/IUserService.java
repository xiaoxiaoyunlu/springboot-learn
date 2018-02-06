package com.zsy.WXDemo.service;

import com.zsy.WXDemo.domain.db.User;

public interface IUserService {
	
	public void register(User user)throws Exception;
	
	public int checkRegister(String open_id)throws Exception;

}

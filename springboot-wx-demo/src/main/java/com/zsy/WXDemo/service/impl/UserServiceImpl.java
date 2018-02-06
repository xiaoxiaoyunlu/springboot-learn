package com.zsy.WXDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsy.WXDemo.domain.db.User;
import com.zsy.WXDemo.mapper.UserMapper;
import com.zsy.WXDemo.service.IUserService;

@Service
public class UserServiceImpl extends BaseService implements IUserService {
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void register(User user) throws Exception {
         userMapper.save(user);
	}

	@Override
	public int checkRegister(String open_id) throws Exception {
		return userMapper.checkRegister(open_id);
	}

}

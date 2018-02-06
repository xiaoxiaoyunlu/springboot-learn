package com.zsy.WXDemo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.zsy.WXDemo.domain.db.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
	
	public int checkRegister(String open_id)throws Exception;

}

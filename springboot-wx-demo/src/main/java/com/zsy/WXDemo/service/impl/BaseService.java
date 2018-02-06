package com.zsy.WXDemo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.zsy.WXDemo.common.Code;

/**
 * 所有service的父类
 * 
 * @author zj
 *
 */
@SuppressWarnings("all")
public abstract class BaseService {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	protected final int code = Code.PARAM_ERROR.getCode();
	protected final String message = Code.PARAM_ERROR.getMessage();

}

package com.zsy.WXDemo.domain.db;


import com.zsy.WXDemo.common.Code;


/**
 * 请求结果对象
 * @author zj
 *
 */
public class Result {
	private boolean success;
	private Integer code;
	private String  message;
	private Object  rows;
	private Integer total;
	
	/**
	 * 成功返回
	 */
	public Result() {
		super();
		this.success = true;
		this.code    = Code.SUCCESS.getCode();
		this.message = Code.SUCCESS.getMessage();
	}
	
	/**
	 * 成功返回
	 */
	public Result(String message) {
		super();
		this.success = true;
		this.code    = Code.SUCCESS.getCode();
		this.message = message;
	}
	
	/**
	 * 错误返回
	 * @param success
	 * @param code
	 * @param message
	 */
	public Result(Integer code, String message) {
		this.success = false;
		this.code    = code;
		this.message = message;
	}
	
	/**
	 * 分页信息返回
	 * @return
	 */
	public Result(Object rows, Integer total) {
		this.success = true;
		this.code    = Code.SUCCESS.getCode();
		this.message = Code.SUCCESS.getMessage();
		this.rows    = rows;
		this.total   = total;
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getRows() {
		return rows;
	}

	public void setRows(Object rows) {
		this.rows = rows;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}

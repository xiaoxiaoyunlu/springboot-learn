package com.zsy.WXDemo.common;

/**
 * 1-1000    系统类型返回码 
 * 1000-5000 业务类型返回码
 * 
 * @author zj
 * 
 */
public enum Code {
    /*************************************************
     *              系统类型返回码                                                                      *
     *************************************************/
     /*** 成功 ***/
     SUCCESS(200,"成功"),
     /*** 系统异常 ***/
     SYSTEM_ERROR(500, "系统异常，请稍后重试"),
     /*** 数据不存在 ***/
     DATA_NOT_EXIST(600, "数据不存在"),
     /*** 数据已存在 ***/
     DATA_EXIST(601, "数据已存在"),
     /*** 参数错误 ***/
     PARAM_ERROR(700, "参数错误"),
     /*** 上传文件失败 ***/
     UPLOAD_FILE_ERROR(800, "上传文件失败"),
     /*** 文件大小错误 ***/
     FILE_SIZE_ERROR(801, "文件大小错误"),
     /*** 文件扩展名错误 ***/
     FILE_TYPE_ERROR(802, "文件扩展名错误"),
     /*************************************************
     *              业务类型返回码                                                                       *
     *************************************************/
     /*** 用户名不存在 ***/
     USERNAME_NOT_EXIST(1000, "用户名不存在"),
     /*** 用户名不能为空 ***/
     USERNAME_IS_BLANK(1001, "用户名不能为空"),
     /*** 用户名长度错误 ***/
     USERNAME_LENGTH_ERROR(1002, "用户名请输入2-16位字符"),
     /*** 用户名已存在 ***/
     USERNAME_EXIST(1003, "用户名已存在"),
     /*** 密码错误 ***/
     PASSWORD_ERROR(1010, "密码错误，请重新输入"),
     /*** 密码不能为空 ***/
     PASSWORD_IS_BLANK(1011, "密码不能为空"),
     /*** 密码长度错误 ***/
     PASSWORD_LENGTH_ERROR(1012, "密码请输入5-20位字符"),
     /*** 新密码与确认密码不一致 ***/
     PASSWORD_DIFFERENT(1013, "新密码与确认密码不一致"),
     /*** 旧密码与新密码不能一致 ***/
     OLD_NEW_PASSWORD_SAME(1014, "旧密码与新密码不能一致"),
     /*** 旧密码错误 ***/
     OLD_PASSWORD_ERROR(1015, "旧密码错误"),
     /*** 旧密码错误 ***/
     DATA_QUOTE_ERROR(1020, "数据已被引用，不能删除"),
     /*** 验证码 ***/
     CHECKCODE__ERROR(1021, "验证码错误"),
	;

	Code(int code, String message) {
		this.code = code;
		this.message = message;
	}

	private int code;
	private String message;

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}

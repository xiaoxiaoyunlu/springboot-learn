package oz.mano.online.common;

/**
 * 1-1000 系统类型返回码 1000-5000 业务类型返回码
 * 
 * @author zj
 * 
 */
public enum Code {
	/*************************************************
	 * 系统类型返回码 *
	 *************************************************/
	/*** 默认，不用设置    成功 ***/
	SUCCESS(0, "成功"),
	/*** 系统异常 ***/
	SYSTEM_ERROR(500, "系统繁忙，请稍后重试."),
	/*** 数据不存在 ***/
	DATA_NOT_EXIST(600, "数据不存在."),
	/*** 数据已存在 ***/
	DATA_EXIST(601, "数据已存在."),
	/*** 参数为空 ***/
	PARA_NULL(700, "参数为空"),
	/*** 参数错误 ***/
	PARAM_ERROR(701, "参数错误"),
	/*** 用户失效 ***/
	USER_INVALID(800, "登录已失效，请重新登录."),
	/*** 文件扩展名错误 ***/
	FILE_TYPE_ERROR(802, "文件扩展名错误"),
	/*************************************************
	 * 业务类型返回码 *
	 *************************************************/
	/*** 用户名不存在 ***/
	USERNAME_NOT_EXIST(1000, "手机号不存在，请注册"),
	/*** 手机号已存在 ***/
	USERNAME_EXIST(1003, "手机号已注册"),
	/*** 用户名不能为空 ***/
	USERNAME_IS_BLANK(1001, "用户名不能为空"),
	/*** 用户名长度错误 ***/
	USERNAME_LENGTH_ERROR(1002, "用户名请输入5-16位字符"),
	/*** 密码错误 ***/
	PASSWORD_ERROR(1010, "密码错误，请重新输入"),
	/*** 密码不能为空 ***/
	PASSWORD_IS_BLANK(1011, "密码不能为空"),
	/*** 密码长度错误 ***/
	PASSWORD_LENGTH_ERROR(1012, "密码请输入5-20位字符"),
	/*** 其他地方登录 ***/
	USER_LOGIN_OTHER(1015, "用户其他地方登录"),
	/*** 未登录 ***/
	USER_NO_LOGIN(1016, "用户未登录"),
	/*** 账户禁用 ***/
	USER_ACCOUNT_DISABLE(1017, "账户已被禁用，请申请恢复"),
	/** 验证码已过期 **/
	CHECKCODE_OUTOF_TIME(1018, "验证码已过期"),
	/** 验证码错误 **/
	CHECKCODE_ERROR(1019, "验证码错误，请重新获取"),
	/** 用户已经领取过优惠券 **/
	USER_HAS_PULL_DISCOUNT(1020, "优惠券已领取"),
	/** 优惠券领完了 **/
	USER_ALL_PULL_DISCOUNT(1021, "抱歉，优惠券领完了"),
	/** 验证码已发送 **/
	CHECKCODE_SENDED(1022, "验证码已发送"),
	/** 配送超出距离 **/
	SEND_OUT_OF_DISTANCE(1023, "配送超过距离"),
	/** 购物车商品失效 **/
	CART_GOOD_INVALID(1024, "购物车商品失效"),
	/** 已处理 **/
	ORDER_PAY_HAS_DONE(1025, "已处理，请勿重复提交"),
	/** 支付金额不匹配，非法支付 **/
	ORDER_PAY_INVALID_MONEY(1026, "支付金额不匹配"),
	/** 账户余额不足 **/
	USER_YU_E_INSUFFICIENT(1027, "账户余额不足,请充值"),
	/** 未找到余额支付记录 **/
	USER_YU_E_PAY_NOT_FIND(1028, "未找到余额支付记录"),
	/** 未找到订单支付流水 **/
	ORDER_PAY_NOT_FOUND(1029, "未找到订单支付流水"),
	/** 未处理的退款请求 **/
	ORDER_REFUND_TO_DO(1030, "未处理的退款情况"),
	/** 退款请求已完成 **/
	ORDER_REFUND_DONE(1031, "退款成功"),
	/** 店铺不存在 **/
	SHOP_NOT_EXISTS(1032, "店铺不存在"),
	/** 店铺上架商品数量不足 **/
	SHOP_NOT_ENOUGH_GOOD_ON_SALE(1033, "店铺上架商品数量不足"),
	/** 订单未找到 **/
	ORDER_NOT_EXISTS(1034, "订单不存在"),
	/** 商品不存在 **/
	GOOD_NOT_EXISTS(1035, "商品不存在"),
	/** 终端资质审核未通过 **/
	TERMINAL_QUALIFICATION_UNCHECK(1036, "终端资质审核未通过"),
	/** 店铺尚未装修完毕 **/
	SHOP_NOT_DECORATE(1037, "店铺尚未装修完毕"),
	/** 优惠券过期 **/
	DISCOUNT_OUT_OF_DATE(1038, "优惠券过期"),
	/** 优惠券已经使用 **/
	DISCOUNT_HAS_USED(1039, "优惠券已使用"),
	/** 优惠券找不到  **/
	DISCOUNT_NOT_FOUND(1040, "优惠券不存在或者没有领取"),
	/** 订单已支付 **/
	ORDER_HAS_PAY(1041, "订单已支付"),
	/** 非店铺订单 **/
	ORDER_NO_SHOP_DO(1042, "不是店铺订单，无权操作"),
	/** 订单未支付 **/
	ORDER_NO_PAY(1043, "订单未付款"),
	/** 订单编号超时 **/
	PAY_CODE_TIMEOUT(1044, "获取订单编号超时"),
	/** 订单编号金额零元 **/
	PAY_CODE_ZERO_MONEY(1045, "获取订单编号金额零元"),
	/** 订单编号出错 **/
	PAY_CODE_PARA_ERROR(1046, "获取订单编号参数出错"),
	/** 支付方式不存在 **/
	PAY_CODE_INVALID_CHANNEL(1047, "非法的支付渠道，请联系客户"),
	/** 商品sku不存在 **/
	GOOD_SKU_INVALID(1048, "商品sku失效或者不存在"),
	/** 无权进行操作**/
	NO_PERMISSION_OPERATION(1080, "没有权限进行该操作"),
	/** 店铺标签重复添加**/
	SHOP_TAG_HAS_EXIEST(1081, "店铺标签重复添加"),
	/** 非法的发送消息实体**/
	MQ_BODY_PUSH_NULL(1082, "推送消息实体为null"),
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

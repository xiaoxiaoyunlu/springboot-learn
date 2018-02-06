package com.mano.rule;

import org.apache.catalina.Context;

/**
 * 规则执行器，可以有多种实现
 */
public interface RuleExecutor<T extends Rule> {
	/**
	 * 返回执行器类型
	 * 
	 * @return
	 */
	String getType();

	/**
	 * 执行规则，并把结果放到上下文上
	 * 
	 * @param context
	 * @return 返回条件是否成立
	 */
	boolean execute(Context context, T rule);
}

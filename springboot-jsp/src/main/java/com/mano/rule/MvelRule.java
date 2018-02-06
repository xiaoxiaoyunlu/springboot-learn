package com.mano.rule;

import com.mano.util.StringUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * 采用MVEL表达式作为条件实现
 * 
 * @author yancheng11334
 * 
 */
@XStreamAlias("mvel-rule")
public class MvelRule extends Rule {
	// 匹配条件
	private String condition;
	// 后续操作
	private String action;

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getType() {
		return "mvel";
	}

	public String toString() {
		return "MvelRule [condition=" + condition + ", action=" + action
				+ ", type=" + getType() + ", id=" + getId() + ", priority="
				+ getPriority() + ", multipleTimes=" + isMultipleTimes()
				+ ",exclusive=" + isExclusive() + "]";
	}

	/**
	 * 验证mvel规则的合法性
	 */
	public boolean isVaild() {
		if (StringUtil.INSTANCE.isEmpty(getCondition())) {
			throw new RuntimeException(String.format("规则[%s]的匹配条件为空", getId()));
		}
		if (StringUtil.INSTANCE.isEmpty(getAction())) {
			throw new RuntimeException(String.format("规则[%s]的后续操作为空", getId()));
		}
		return true;
	}
}
package com.mano.rule;

public class Rule {

	int priority;
	String id;
	boolean exclusive;
	boolean multipleTimes;
	String description;
	String title;
	String type;
	boolean valid;

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isExclusive() {
		return exclusive;
	}

	public void setExclusive(boolean exclusive) {
		this.exclusive = exclusive;
	}

	public boolean isMultipleTimes() {
		return multipleTimes;
	}

	public void setMultipleTimes(boolean multipleTimes) {
		this.multipleTimes = multipleTimes;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	public boolean equals(Object obj) {
		return true;

	};

	public int compareTo(Rule rule) {
		return 0;
	};

}
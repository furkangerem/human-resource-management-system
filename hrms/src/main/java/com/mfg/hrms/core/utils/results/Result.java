package com.mfg.hrms.core.utils.results;

import lombok.Data;

@Data
public class Result {

	private String message;
	private boolean success;

	public Result(boolean success) {
		this.success = success;
	}

	public Result(String message, boolean success) {
		this(success);
		this.message = message;
	}
}
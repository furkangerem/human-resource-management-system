package com.mfg.hrms.core.utils.results;

import lombok.Data;

@Data
public class DataResult<T> extends Result {

	private T data;

	public DataResult(T data, String message, boolean success) {
		super(message, success);
		this.data = data;
	}

	public DataResult(T data, boolean success) {
		super(success);
		this.data = data;
	}
}
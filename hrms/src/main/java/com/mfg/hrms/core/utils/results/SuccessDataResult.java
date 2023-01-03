package com.mfg.hrms.core.utils.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, message, true);
	}

	public SuccessDataResult(T data) {
		super(data, true);
	}
}
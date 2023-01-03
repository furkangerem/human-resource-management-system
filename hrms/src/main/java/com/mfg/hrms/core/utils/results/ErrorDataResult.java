package com.mfg.hrms.core.utils.results;

public class ErrorDataResult<T> extends DataResult<T> {

	public ErrorDataResult(T data, String message) {
		super(data, message, false);
	}

	public ErrorDataResult(T data) {
		super(data, false);
	}
}
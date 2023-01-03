package com.mfg.hrms.core.utils.results;

public class ErrorResult extends Result {

	public ErrorResult() {
		super(false);
	}

	public ErrorResult(String message) {
		super(message, false);
	}
}
package com.mfg.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.core.verifications.abstracts.IEmployeeVerificationService;

@Service
public class EmployeeVerificationManager implements IEmployeeVerificationService {

	@Override
	public Result verifyAccount() {
		return new SuccessResult("Account is verified by HRMS.");
	}
}
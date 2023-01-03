package com.mfg.hrms.core.verifications.concretes;

import org.springframework.stereotype.Service;

import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.core.verifications.abstracts.IEmailVerificationService;

@Service
public class EmailVarificationManager implements IEmailVerificationService {

	@Override
	public Result verifyEmail(String email) {
		// TODO Auto-generated method stub
		return new SuccessResult("Please verify your account. We sent the e-mail to your e-mail address: " + email);
	}

}
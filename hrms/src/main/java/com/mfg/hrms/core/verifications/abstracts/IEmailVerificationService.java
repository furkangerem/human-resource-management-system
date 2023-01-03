package com.mfg.hrms.core.verifications.abstracts;

import com.mfg.hrms.core.utils.results.Result;

public interface IEmailVerificationService {

	Result verifyEmail(String email);
}
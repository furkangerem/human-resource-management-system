package com.mfg.hrms.business.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.IEmployerService;
import com.mfg.hrms.business.validation.abstracts.IValidationRuleService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessDataResult;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.core.verifications.abstracts.IEmailVerificationService;
import com.mfg.hrms.core.verifications.abstracts.IEmployeeVerificationService;
import com.mfg.hrms.dataAccess.abstracts.IEmployerDao;
import com.mfg.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements IEmployerService {

	private IEmployerDao iEmployerDao;
	private IValidationRuleService iValidationRuleService;
	private IEmailVerificationService iEmailVerificationService;
	private IEmployeeVerificationService iEmployeeVerificationService;

	@Autowired
	public EmployerManager(IEmployerDao iEmployerDao, IValidationRuleService iValidationRuleService, IEmailVerificationService iEmailVerificationService,
			IEmployeeVerificationService iEmployeeVerificationService) {
		super();
		this.iEmployerDao = iEmployerDao;
		this.iValidationRuleService = iValidationRuleService;
		this.iEmailVerificationService = iEmailVerificationService;
		this.iEmployeeVerificationService = iEmployeeVerificationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {

		return new SuccessDataResult<List<Employer>>(iEmployerDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(Employer employer) {

		Result validationResult = this.iValidationRuleService.checkEmployer(employer);
		if (!validationResult.isSuccess())
			return new ErrorResult(validationResult.getMessage());

		boolean emailValidationResult = checkEmail(employer);
		if (emailValidationResult)
			return new ErrorResult("E-mail already exists.");

		System.out.println(this.iEmailVerificationService.verifyEmail(employer.getEmail()).getMessage() + "\n" + this.iEmployeeVerificationService.verifyAccount().getMessage());
		this.iEmployerDao.save(employer);
		return new SuccessResult("The employer is added successfully.");
	}

	// Auxiliary Functions
	public boolean checkEmail(Employer employer) {

		Employer findByEmailResult = this.iEmployerDao.findByEmail(employer.getEmail());
		if (findByEmailResult == null)
			return false;
		return true;
	}
}
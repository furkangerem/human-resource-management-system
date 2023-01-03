package com.mfg.hrms.business.entities;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.ICandidateService;
import com.mfg.hrms.business.validation.abstracts.IValidationRuleService;
import com.mfg.hrms.core.adapters.abstracts.IMernisService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessDataResult;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.core.verifications.abstracts.IEmailVerificationService;
import com.mfg.hrms.dataAccess.abstracts.ICandidateDao;
import com.mfg.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements ICandidateService {

	private ICandidateDao iCandidateDao;
	private IMernisService iMernisService;
	private IValidationRuleService iValidationRuleService;
	private IEmailVerificationService iEmailVerificationService;

	@Autowired
	public CandidateManager(ICandidateDao iCandidateDao, IMernisService iMernisService, IValidationRuleService validationRuleService,
			IEmailVerificationService iEmailVerificationService) {
		super();
		this.iCandidateDao = iCandidateDao;
		this.iMernisService = iMernisService;
		this.iValidationRuleService = validationRuleService;
		this.iEmailVerificationService = iEmailVerificationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {

		return new SuccessDataResult<List<Candidate>>(iCandidateDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(Candidate candidate) throws NumberFormatException, RemoteException {

		Result validationResult = iValidationRuleService.checkCandidate(candidate);
		if (!validationResult.isSuccess()) {
			return new ErrorResult(validationResult.getMessage());
		}

		boolean mernisValidationResult = checkCandidate(candidate);
		if (!mernisValidationResult) {
			return new ErrorResult("The person does not exist. Plase check the given info.");
		}

		boolean emailAndIdValidationResult = checkEmailAndId(candidate);
		if (emailAndIdValidationResult)
			return new ErrorResult("E-mail or identity number already exists.");

		System.out.println(this.iEmailVerificationService.verifyEmail(candidate.getEmail()).getMessage());
		this.iCandidateDao.save(candidate);
		return new SuccessResult("The candidate is added successfully.");
	}

	// Auxiliary Functions

	public boolean checkCandidate(Candidate candidate) throws NumberFormatException, RemoteException {

		boolean mernisValidationResult = this.iMernisService.checkPerson(candidate);
		if (!mernisValidationResult)
			return false;
		return true;
	}

	public boolean checkEmailAndId(Candidate candidate) {

		Candidate findByEmailOrIdentitynumberResult = this.iCandidateDao.findByEmailOrIdentityNumber(candidate.getEmail(), candidate.getIdentityNumber());
		if (findByEmailOrIdentitynumberResult == null)
			return false;
		return true;
	}
}
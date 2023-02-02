package com.mfg.hrms.business.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.IJobAdvertisementService;
import com.mfg.hrms.business.validation.abstracts.IValidationRuleService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessDataResult;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.dataAccess.abstracts.IJobAdvertisementDao;
import com.mfg.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements IJobAdvertisementService {

	private IJobAdvertisementDao iJobAdvertisementDao;
	private IValidationRuleService iValidationRuleService;

	@Autowired
	public JobAdvertisementManager(IJobAdvertisementDao iJobAdvertisementDao, IValidationRuleService iValidationRuleService) {
		super();
		this.iJobAdvertisementDao = iJobAdvertisementDao;
		this.iValidationRuleService = iValidationRuleService;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(iJobAdvertisementDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

		Result validationResult = this.iValidationRuleService.checkJobAdvertisement(jobAdvertisement);
		if (!validationResult.isSuccess())
			return new ErrorResult(validationResult.getMessage());

		iJobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job advertisement has added successfully.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisement() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.iJobAdvertisementDao.getByStatusTrue(), "Active job advertisements are successfully listed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementOrderedByDesc() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.iJobAdvertisementDao.getByStatusTrueOrderByStartDateDesc(),
				"Active job advertisements are successfully listed by date.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getActiveJobAdvertisementWithSpecificCompany(String companyName) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.iJobAdvertisementDao.getByStatusTrueAndEmployer_CompanyName(companyName),
				"Job advertisements are listed by the desired company.");
	}

	@Override
	public Result updateJobAdvertisementStatus(int jobAdvertisementId) {

		this.iJobAdvertisementDao.updateJobAdvertisementStatus(jobAdvertisementId);
		return new SuccessResult("Selected Job Advertisement is closed.");
	}
}
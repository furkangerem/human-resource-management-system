package com.mfg.hrms.business.abstracts;

import java.util.List;

import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.JobAdvertisement;

public interface IJobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement jobAdvertisement);
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisement();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisementOrderedByDesc();
	DataResult<List<JobAdvertisement>> getActiveJobAdvertisementWithSpecificCompany(String companyName);
	Result updateJobAdvertisementStatus(int jobAdvertisementId);
}
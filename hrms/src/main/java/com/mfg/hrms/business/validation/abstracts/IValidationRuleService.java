package com.mfg.hrms.business.validation.abstracts;

import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.Candidate;
import com.mfg.hrms.entities.concretes.City;
import com.mfg.hrms.entities.concretes.Employer;
import com.mfg.hrms.entities.concretes.JobAdvertisement;

public interface IValidationRuleService {

	Result checkCandidate(Candidate candidate);

	Result checkEmployer(Employer employer);

	Result checkCity(City city);

	Result checkJobAdvertisement(JobAdvertisement jobAdvertisement);
}
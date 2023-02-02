package com.mfg.hrms.business.validation.entities;

import java.time.Year;

import org.springframework.stereotype.Service;

import com.mfg.hrms.business.validation.abstracts.IValidationRuleService;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.entities.concretes.Candidate;
import com.mfg.hrms.entities.concretes.City;
import com.mfg.hrms.entities.concretes.Employer;
import com.mfg.hrms.entities.concretes.JobAdvertisement;

@Service
public class ValidationRuleManager implements IValidationRuleService {

	@Override
	public Result checkCandidate(Candidate candidate) {

		Year currentYear = Year.now();

		if (candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() || candidate.getIdentityNumber().isEmpty() || candidate.getEmail().isEmpty()
				|| candidate.getPassword().isEmpty()) {
			return new ErrorResult("Please fill the blanks completely.");
		}

		if (candidate.getBirthYear() <= 0 || candidate.getBirthYear() > currentYear.getValue()) {
			return new ErrorResult("Wrong birth of year.");
		}
		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkEmployer(Employer employer) {

		if (employer.getCompanyName().isEmpty() || employer.getWebAddress().isEmpty() || employer.getEmail().isEmpty() || employer.getPhoneNumber().isEmpty()
				|| employer.getPassword().isEmpty())
			return new ErrorResult("Please fill the blanks completely.");
		else if (!employer.getEmail().contains(employer.getWebAddress()))
			return new ErrorResult("Your email must contains the domain in it.");

		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkCity(City city) {

		if (city.getName().isEmpty())
			return new ErrorResult("The city name can not be empty.");
		return new SuccessResult("Validation OK.");
	}

	@Override
	public Result checkJobAdvertisement(JobAdvertisement jobAdvertisement) {

		if (jobAdvertisement.getDescription().isEmpty())
			return new ErrorResult("Please fill the blanks completely.");
		if (jobAdvertisement.getFreePositionAmount() <= 0)
			return new ErrorResult("Free position amount can't be zero or less.");

		return new SuccessResult("Validation OK.");
	}
}
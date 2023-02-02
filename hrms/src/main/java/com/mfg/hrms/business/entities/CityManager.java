package com.mfg.hrms.business.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.ICityService;
import com.mfg.hrms.business.validation.abstracts.IValidationRuleService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessDataResult;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.dataAccess.abstracts.ICityDao;
import com.mfg.hrms.entities.concretes.City;

@Service
public class CityManager implements ICityService {

	private ICityDao iCityDao;
	private IValidationRuleService iValidationRuleService;

	@Autowired
	public CityManager(ICityDao iCityDao, IValidationRuleService iValidationRuleService) {
		super();
		this.iCityDao = iCityDao;
		this.iValidationRuleService = iValidationRuleService;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.iCityDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(City city) {

		Result validationResult = this.iValidationRuleService.checkCity(city);
		if (!validationResult.isSuccess())
			return new ErrorResult(validationResult.getMessage());

		boolean checkCityResult = checkCity(city);
		if (checkCityResult)
			return new ErrorResult("The city already exists.");

		this.iCityDao.save(city);
		return new SuccessResult("The city is added successfully.");
	}

	// Auxiliary Functions
	public boolean checkCity(City city) {

		City findByName = this.iCityDao.findByName(city.getName());
		if (findByName == null)
			return false;
		return true;
	}
}
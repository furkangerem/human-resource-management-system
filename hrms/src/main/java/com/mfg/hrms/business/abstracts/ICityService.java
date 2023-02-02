package com.mfg.hrms.business.abstracts;

import java.util.List;

import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.City;

public interface ICityService {

	DataResult<List<City>> getAll();

	Result add(City city);
}
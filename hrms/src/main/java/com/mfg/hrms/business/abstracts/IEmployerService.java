package com.mfg.hrms.business.abstracts;

import java.util.List;

import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.Employer;

public interface IEmployerService {

	DataResult<List<Employer>> getAll();

	Result add(Employer employer);
}
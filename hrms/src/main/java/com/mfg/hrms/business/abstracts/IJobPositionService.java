package com.mfg.hrms.business.abstracts;

import java.util.List;

import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.JobPosition;

public interface IJobPositionService {

	// We should take data from DataResult instead of taking directly.
	// List<JobPosition> getAll();
	DataResult<List<JobPosition>> getAll();

	Result add(JobPosition jobPosition);
}
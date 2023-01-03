package com.mfg.hrms.business.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.IJobPositionService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.ErrorResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.core.utils.results.SuccessDataResult;
import com.mfg.hrms.core.utils.results.SuccessResult;
import com.mfg.hrms.dataAccess.abstracts.IJobPositionDao;
import com.mfg.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements IJobPositionService {

	private IJobPositionDao iJobPositionDao;

	@Autowired
	public JobPositionManager(IJobPositionDao iJobPositionDao) {
		super();
		this.iJobPositionDao = iJobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {

		return new SuccessDataResult<List<JobPosition>>(iJobPositionDao.findAll(), "Query returned successfully.");
	}

	@Override
	public Result add(JobPosition jobPosition) {
		
		if(this.iJobPositionDao.findByTitle(jobPosition.getTitle()) != null) {
			return new ErrorResult("Job position exists in the database.");
		}

		this.iJobPositionDao.save(jobPosition);
		return new SuccessResult("Job position has added successfully.");
	}
}
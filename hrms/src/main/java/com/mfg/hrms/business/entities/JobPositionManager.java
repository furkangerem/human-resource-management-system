package com.mfg.hrms.business.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfg.hrms.business.abstracts.IJobPositionService;
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
	public List<JobPosition> getAll() {

		return iJobPositionDao.findAll();
	}
}
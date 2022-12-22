package com.mfg.hrms.business.abstracts;

import java.util.List;

import com.mfg.hrms.entities.concretes.JobPosition;

public interface IJobPositionService {

	List<JobPosition> getAll();
}
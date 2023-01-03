package com.mfg.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfg.hrms.entities.concretes.JobPosition;

public interface IJobPositionDao extends JpaRepository<JobPosition, Integer> {

	JobPosition findByTitle(String positionName);
}
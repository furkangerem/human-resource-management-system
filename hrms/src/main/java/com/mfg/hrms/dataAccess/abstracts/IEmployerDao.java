package com.mfg.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfg.hrms.entities.concretes.Employer;

public interface IEmployerDao extends JpaRepository<Employer, Integer> {

	Employer findByEmail(String email);
}
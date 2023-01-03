package com.mfg.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfg.hrms.entities.concretes.Candidate;

public interface ICandidateDao extends JpaRepository<Candidate, Integer> {

	Candidate findByEmailOrIdentityNumber(String email, String identityNumber);
}
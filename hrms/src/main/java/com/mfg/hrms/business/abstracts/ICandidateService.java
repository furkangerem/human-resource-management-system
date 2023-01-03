package com.mfg.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.Candidate;

public interface ICandidateService {

	DataResult<List<Candidate>> getAll();

	Result add(Candidate candidate) throws NumberFormatException, RemoteException;
}
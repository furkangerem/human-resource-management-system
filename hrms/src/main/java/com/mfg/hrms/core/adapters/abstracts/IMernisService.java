package com.mfg.hrms.core.adapters.abstracts;

import java.rmi.RemoteException;

import com.mfg.hrms.entities.concretes.Candidate;

public interface IMernisService {

	public boolean checkPerson(Candidate candidate) throws NumberFormatException, RemoteException;
}
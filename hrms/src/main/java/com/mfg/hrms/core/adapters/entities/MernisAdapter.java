package com.mfg.hrms.core.adapters.entities;

import java.rmi.RemoteException;

import org.springframework.stereotype.Service;

import com.mfg.hrms.core.adapters.abstracts.IMernisService;
import com.mfg.hrms.entities.concretes.Candidate;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisAdapter implements IMernisService {

	// TODO: Why does not work this?
	/*
	 * private KPSPublicSoapProxy kpsPublicSoapProxy;
	 * 
	 * @Autowired public MernisAdapter(KPSPublicSoapProxy kpsPublicSoapProxy) {
	 * super(); this.kpsPublicSoapProxy = kpsPublicSoapProxy; }
	 */

	@Override
	public boolean checkPerson(Candidate candidate) throws NumberFormatException, RemoteException {

		KPSPublicSoapProxy kpsPublicSoapProxy = new KPSPublicSoapProxy();

		return kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(candidate.getIdentityNumber()),
				candidate.getFirstName().toUpperCase(), candidate.getLastName().toUpperCase(),
				candidate.getBirthYear());
	}
}
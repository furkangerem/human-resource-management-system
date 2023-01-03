package com.mfg.hrms.webApi.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.ICandidateService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

	private ICandidateService iCandidateService;

	@Autowired
	public CandidateController(ICandidateService iCandidateService) {
		super();
		this.iCandidateService = iCandidateService;
	}

	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll() {

		return this.iCandidateService.getAll();
	}

	@PostMapping("/addCandidate")
	public Result add(@RequestBody Candidate candidate) throws NumberFormatException, RemoteException {

		return this.iCandidateService.add(candidate);
	}
}
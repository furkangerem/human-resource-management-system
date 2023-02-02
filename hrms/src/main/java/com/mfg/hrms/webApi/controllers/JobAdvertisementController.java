package com.mfg.hrms.webApi.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.IJobAdvertisementService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisements")
public class JobAdvertisementController {

	private IJobAdvertisementService iJobAdvertisementService;

	@Autowired
	public JobAdvertisementController(IJobAdvertisementService iJobAdvertisementService) {
		super();
		this.iJobAdvertisementService = iJobAdvertisementService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll() {
		return this.iJobAdvertisementService.getAll();
	}

	@PostMapping("/addjobadvertisement")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.iJobAdvertisementService.add(jobAdvertisement);
	}

	@GetMapping("/getactivejobadvertisement")
	public DataResult<List<JobAdvertisement>> getByStatus() {
		return this.iJobAdvertisementService.getActiveJobAdvertisement();
	}

	@GetMapping("/getactivejobadvertisementbydate")
	DataResult<List<JobAdvertisement>> getByStatusTrueOrderByCreateDateDesc() {
		return this.iJobAdvertisementService.getActiveJobAdvertisementOrderedByDesc();
	}

	@GetMapping("/getactivejobadvertisementbycompany")
	DataResult<List<JobAdvertisement>> getByStatusTrueAndEmployer_CompanyName(String companyName) {
		return this.iJobAdvertisementService.getActiveJobAdvertisementWithSpecificCompany(null);
	}

	@PostMapping("/updatejobadvertisementstatusbyid")
	@Transactional
	public Result UpdateJobAdvertisementSetStatusForEmployer_Id(@RequestParam int jobAdvertisementId) {
		return this.iJobAdvertisementService.updateJobAdvertisementStatus(jobAdvertisementId);
	}
}
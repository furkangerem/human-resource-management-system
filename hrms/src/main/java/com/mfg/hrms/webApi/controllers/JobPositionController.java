package com.mfg.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.IJobPositionService;
import com.mfg.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionController {

	private IJobPositionService iJobPositionService;

	@Autowired
	public JobPositionController(IJobPositionService iJobPositionService) {
		super();
		this.iJobPositionService = iJobPositionService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {

		return this.iJobPositionService.getAll();
	}
}
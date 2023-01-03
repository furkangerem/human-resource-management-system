package com.mfg.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.IJobPositionService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.JobPosition;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

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
	public DataResult<List<JobPosition>> getAll() {

		return this.iJobPositionService.getAll();
	}

	@PostMapping("/addJobPosition")
	public Result add(@RequestBody JobPosition jobPosition) {

		return this.iJobPositionService.add(jobPosition);
	}
}
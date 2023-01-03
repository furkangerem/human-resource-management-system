package com.mfg.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.IEmployerService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {

	private IEmployerService iEmployerService;

	@Autowired
	public EmployerController(IEmployerService iEmployerService) {
		super();
		this.iEmployerService = iEmployerService;
	}

	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll() {

		return this.iEmployerService.getAll();
	}

	@PostMapping("/addEmployer")
	public Result add(@RequestBody Employer employer) {

		return this.iEmployerService.add(employer);
	}
}
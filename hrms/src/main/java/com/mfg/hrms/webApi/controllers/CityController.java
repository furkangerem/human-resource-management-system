package com.mfg.hrms.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfg.hrms.business.abstracts.ICityService;
import com.mfg.hrms.core.utils.results.DataResult;
import com.mfg.hrms.core.utils.results.Result;
import com.mfg.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private ICityService iCityService;

	@Autowired
	public CityController(ICityService iCityService) {
		super();
		this.iCityService = iCityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll() {

		return this.iCityService.getAll();
	}

	@PostMapping("/addcity")
	public Result add(@RequestBody City city) {

		return this.iCityService.add(city);
	}
}
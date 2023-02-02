package com.mfg.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mfg.hrms.entities.concretes.City;

public interface ICityDao extends JpaRepository<City, Integer> {

	City findByName(String name);
}
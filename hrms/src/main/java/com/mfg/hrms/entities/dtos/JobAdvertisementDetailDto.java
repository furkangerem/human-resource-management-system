package com.mfg.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDetailDto {

	private String companyName;
	private String jobTitle;
	private String city;
	private int freePositionAmount;
	private Date startDate;
	private Date endDate;
}
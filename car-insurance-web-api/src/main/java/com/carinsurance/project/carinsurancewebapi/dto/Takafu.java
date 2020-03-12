package com.carinsurance.project.carinsurancewebapi.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Takafu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Company")
	private String company;
	
	@JsonProperty("Islamic")
	private String isIslamic;
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIsIslamic() {
		return isIslamic;
	}
	public void setIsIslamic(String isIslamic) {
		this.isIslamic = isIslamic;
	}

}

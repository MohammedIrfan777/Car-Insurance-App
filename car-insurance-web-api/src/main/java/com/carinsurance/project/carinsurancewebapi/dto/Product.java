package com.carinsurance.project.carinsurancewebapi.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Product implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("Company")
	private String company;
	
	@JsonProperty("Product")
	private String product;
	
	@JsonProperty("Amount")
	private long amount;
	
	@JsonProperty("ModelFrom")
	private int modelFrom;
	
	@JsonProperty("ModelTo")
	private int modelTo;
	
	@JsonProperty("BrandsCovered")
	private String brandsCovered;
	
	@JsonProperty("TAXPercentage")
	private int taxPercentage;
	
	
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public int getModelFrom() {
		return modelFrom;
	}
	public void setModelFrom(int modelFrom) {
		this.modelFrom = modelFrom;
	}
	public int getModelTo() {
		return modelTo;
	}
	public void setModelTo(int modelTo) {
		this.modelTo = modelTo;
	}
	public String getBrandsCovered() {
		return brandsCovered;
	}
	public void setBrandsCovered(String brandsCovered) {
		this.brandsCovered = brandsCovered;
	}
	public int getTaxPercentage() {
		return taxPercentage;
	}
	public void setTaxPercentage(int taxPercentage) {
		this.taxPercentage = taxPercentage;
	}
}

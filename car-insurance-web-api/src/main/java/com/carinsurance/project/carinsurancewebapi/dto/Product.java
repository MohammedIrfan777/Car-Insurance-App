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
	
	@JsonProperty("takaful")
	private String takaful;
	
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
	public String getTakaful() {
		return takaful;
	}
	public void setTakaful(String takaful) {
		this.takaful = takaful;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (amount ^ (amount >>> 32));
		result = prime * result + ((brandsCovered == null) ? 0 : brandsCovered.hashCode());
		result = prime * result + ((company == null) ? 0 : company.hashCode());
		result = prime * result + modelFrom;
		result = prime * result + modelTo;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((takaful == null) ? 0 : takaful.hashCode());
		result = prime * result + taxPercentage;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (amount != other.amount)
			return false;
		if (brandsCovered == null) {
			if (other.brandsCovered != null)
				return false;
		} else if (!brandsCovered.equals(other.brandsCovered))
			return false;
		if (company == null) {
			if (other.company != null)
				return false;
		} else if (!company.equals(other.company))
			return false;
		if (modelFrom != other.modelFrom)
			return false;
		if (modelTo != other.modelTo)
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (takaful == null) {
			if (other.takaful != null)
				return false;
		} else if (!takaful.equals(other.takaful))
			return false;
		if (taxPercentage != other.taxPercentage)
			return false;
		return true;
	}
}

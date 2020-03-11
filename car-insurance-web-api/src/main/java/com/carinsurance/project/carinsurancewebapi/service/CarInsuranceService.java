package com.carinsurance.project.carinsurancewebapi.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carinsurance.project.carinsurancewebapi.dto.Product;
import com.carinsurance.project.carinsurancewebapi.dto.Takafu;
import com.carinsurance.project.carinsurancewebapi.respository.CarInsuranceRepository;

@Service
public class CarInsuranceService {
	
	@Autowired
	private CarInsuranceRepository carInsuranceRepository;
	
	public List<Product> getProductDetails() throws IOException {
		return carInsuranceRepository.getProductDetails();
	}
	
	public List<Takafu> getTakaful() throws IOException {
		return carInsuranceRepository.getTakafulDetails();
	}
}

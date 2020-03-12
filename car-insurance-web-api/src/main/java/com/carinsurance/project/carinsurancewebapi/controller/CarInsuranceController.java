package com.carinsurance.project.carinsurancewebapi.controller;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carinsurance.project.carinsurancewebapi.dto.Product;
import com.carinsurance.project.carinsurancewebapi.dto.Takafu;
import com.carinsurance.project.carinsurancewebapi.service.CarInsuranceService;

@RestController
public class CarInsuranceController {
	
	@Autowired
	private CarInsuranceService carInsuranceService;
	
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public ModelAndView getProductDetails() throws IOException {
		
		ModelAndView view = new ModelAndView();
		view.addObject("insuranceData", carInsuranceService.getProductDetails());
		return view;
	}
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome() {
    	ModelAndView model = new ModelAndView();
    	model.setViewName("welcome");
    	return model;
    }
	
	@RequestMapping(value = "/searchdata", method = RequestMethod.POST)
    public @ResponseBody Set<Product> searchData(@RequestParam String prodName, 
    		@RequestParam int modelFrom, @RequestParam int modelTo, @RequestParam String brands) throws IOException {
		Set<Product> resuList = new LinkedHashSet<Product>();
		Set<Product> products = carInsuranceService.getProductDetails();
		products.forEach(product -> {
			if(Year.of(product.getModelFrom()).compareTo(Year.of(modelFrom)) >= 0 &&
					Year.of(product.getModelTo()).compareTo(Year.of(modelTo)) <= 0) {
				
				String[] brandsCovered = product.getBrandsCovered().split(",");
				for(String brand : brandsCovered) {		
					if(brands.equalsIgnoreCase(brand.trim())) {
						try {
							List<Takafu> takafus = carInsuranceService.getTakaful();
							takafus.forEach(takafu -> {
								if(takafu.getCompany().equalsIgnoreCase(product.getCompany())) {
									product.setTakaful(takafu.getIsIslamic());
									resuList.add(product);
								}
							});
							
						} catch (IOException e) {
							e.printStackTrace();
						}
						resuList.add(product);
					}	
				}
			}		
		});
		
    	return new LinkedHashSet<Product>(selectBestPrice(resuList));
    }

	private List<Product> selectBestPrice(Set<Product> resuList) {
		
		List<Product> products = new ArrayList<Product>(resuList);
		Collections.sort(
				products, Comparator.comparing(Product::getAmount));
		List<Product> finalList = new ArrayList<Product>();
		if(!products.isEmpty()) {
			if(products.size() > 1) {
				if(products.get(0).getAmount() == products.get(1).getAmount() && 
						!products.get(0).getTakaful().equalsIgnoreCase(products.get(1).getTakaful())) {
					finalList.add(products.get(0));
					finalList.add(products.get(1));
				}else {
					finalList.add(products.get(0));
				}
			}else {
				finalList.add(products.get(0));
			}
			
		}
		return finalList;
		
	}
}

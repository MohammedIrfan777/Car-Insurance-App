package com.carinsurance.project.carinsurancewebapi.controller;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.carinsurance.project.carinsurancewebapi.dto.Product;
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
	
	@RequestMapping(value = "/welcome/searchdata", method = RequestMethod.POST)
    public @ResponseBody List<Product> searchData(@RequestParam String prodName, 
    		@RequestParam int modelFrom, @RequestParam int modelTo, @RequestParam String brands) throws IOException {
		List<Product> resuList = new ArrayList<Product>();
		List<Product> products = carInsuranceService.getProductDetails();
		products.forEach(product -> {
			if(Year.of(product.getModelFrom()).compareTo(Year.of(modelFrom)) >= 0 &&
					Year.of(product.getModelTo()).compareTo(Year.of(modelTo)) <= 0) {
				
				String[] brandsCovered = product.getBrandsCovered().split(",");
				for(String brand : brandsCovered) {		
					if(brand.equalsIgnoreCase(brands)) {
						resuList.add(product);
					}	
				}
			}		
		});
    	return resuList;
    }
}

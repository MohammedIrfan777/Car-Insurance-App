package com.carinsurance.project.carinsurancewebapi.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.carinsurance.project.carinsurancewebapi.controller.CarInsuranceController;
import com.carinsurance.project.carinsurancewebapi.dto.Product;
import com.carinsurance.project.carinsurancewebapi.dto.Takafu;
import com.carinsurance.project.carinsurancewebapi.service.CarInsuranceService;


@WebAppConfiguration
@WebMvcTest(controllers = CarInsuranceController.class)
public class CarInsuranceControllerTest {
	
	
	private CarInsuranceService carInsuranceService;
	
    private MockMvc mvc;
    
    @Autowired
    private WebApplicationContext wac;
    
    private CarInsuranceController carInsurance;
	
	@Before
	public void setup() {
		carInsuranceService = mock(CarInsuranceService.class);
		this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		this.carInsurance = mock(CarInsuranceController.class);
	}
	
	@Test
	public void testWelcome() throws Exception {
		 mvc.perform(MockMvcRequestBuilders
		            .get("/welcome"))
		            .andExpect(model().size(1))
		            .andExpect(status().isOk());
		 
		 verifyNoMoreInteractions(carInsuranceService);
	}
	
	@Test
	public void testSearchData() throws IOException {
		
		Set<Product> resuList = new LinkedHashSet<Product>();
		resuList = setUpData();
		List<Takafu> takafus = setTakafu();
		when(carInsuranceService.getProductDetails()).thenReturn(resuList);
		when(carInsuranceService.getTakaful()).thenReturn(takafus);
		
		assertEquals(resuList.size(), 1);
		
	}
	

	private List<Takafu> setTakafu() {
		Takafu takafu = new Takafu();
		takafu.setCompany("A");
		takafu.setIsIslamic("Yes");
		List<Takafu> list = new ArrayList<Takafu>();
		list.add(takafu);
		return list;
	}

	private Set<Product> setUpData() {
		
		Product product = new Product();
		product.setAmount(200);
		product.setBrandsCovered("A, B, C, D");
		product.setCompany("A");
		product.setModelFrom(2000);
		product.setModelTo(2017);
		product.setTakaful("Yes");
		product.setTaxPercentage(10);
		Set<Product> resuList = new LinkedHashSet<Product>();
		resuList.add(product);
		return resuList;
	}
}

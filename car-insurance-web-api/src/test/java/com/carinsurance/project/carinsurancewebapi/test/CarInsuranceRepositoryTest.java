package com.carinsurance.project.carinsurancewebapi.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.carinsurance.project.carinsurancewebapi.dto.Product;
import com.carinsurance.project.carinsurancewebapi.dto.Takafu;
import com.carinsurance.project.carinsurancewebapi.respository.CarInsuranceRepository;

public class CarInsuranceRepositoryTest {
	
	private ResourceLoader resourceLoader;
	Resource resource;
	private CarInsuranceRepository repository;
	
	@Before
    public void setUp() {
        this.resourceLoader = mock(ResourceLoader.class);
        resource = mock(Resource.class);
        repository = mock(CarInsuranceRepository.class);
    }

	@Test
	public void testProductDetails() throws IOException {
		String mockFile = "This is my file line";
        InputStream is = new ByteArrayInputStream(mockFile.getBytes());
		Resource mockResource = Mockito.mock(Resource.class);
	    Mockito.when(mockResource.getInputStream()).thenReturn(is);
		
		Mockito.when(resourceLoader.getResource(Mockito.anyString())).thenReturn(mockResource);
		Set<Product> products = repository.getProductDetails();
		assertNotEquals(products.size(), 1);
		
	}
	
	@Test
	public void testTakafutDetails() throws IOException {
		String mockFile = "This is my file line";
        InputStream is = new ByteArrayInputStream(mockFile.getBytes());
		Resource mockResource = Mockito.mock(Resource.class);
	    Mockito.when(mockResource.getInputStream()).thenReturn(is);
		
		Mockito.when(resourceLoader.getResource(Mockito.anyString())).thenReturn(mockResource);
		List<Takafu> products = repository.getTakafulDetails();
		assertNotEquals(products.size(), 1);
		
	}
}

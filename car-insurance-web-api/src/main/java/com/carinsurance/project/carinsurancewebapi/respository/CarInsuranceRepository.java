package com.carinsurance.project.carinsurancewebapi.respository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Repository;

import com.carinsurance.project.carinsurancewebapi.dto.Product;
import com.carinsurance.project.carinsurancewebapi.dto.Takafu;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Repository
public class CarInsuranceRepository {
	
	private ResourceLoader resourceLoader;
	
	@Autowired
    public CarInsuranceRepository(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

	public List<Product> getProductDetails() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:csv/Products.csv");
		InputStream file = resource.getInputStream();
		List<Product> allValues = null;
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
		CsvMapper mapper = new CsvMapper();
		MappingIterator<Product> readValues = mapper.readerFor(Product.class).with(bootstrapSchema).readValues(file);
		try {
			allValues = readValues.readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allValues;
	}
	
	public List<Takafu> getTakafulDetails() throws IOException {
		Resource resource = resourceLoader.getResource("classpath:csv/Takaful.csv");
		InputStream file = resource.getInputStream();
		List<Takafu> allValues = null;
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
		CsvMapper mapper = new CsvMapper();
		MappingIterator<Takafu> readValues = mapper.readerFor(Takafu.class).with(bootstrapSchema).readValues(file);
		try {
			allValues = readValues.readAll();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return allValues;
	}

}

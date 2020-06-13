package com.cognizant.springlearn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.SpringLearnApplication;
import com.cognizant.springlearn.exception.CountryNotFoundException;
import com.cognizant.springlearn.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	CountryService countryService;
	
	private static ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	private static ArrayList<Country> countries =(ArrayList<Country>) context.getBean("countryList");
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	
	
	
	@GetMapping("/")
	public List<Country> getAllCountries()
	{	
		
		return countries;
		
	}
	
	@GetMapping("/{code}")
	public @ResponseBody Country getCountry(@PathVariable String code) throws CountryNotFoundException
	{
		return countryService.getCountry(code);
	}
	@PostMapping()
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("Start");
		
		countries.add(country);
		LOGGER.info("End");
		return country;		
	}
}

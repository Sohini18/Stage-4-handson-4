package com.cognizant.springlearn.service;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country;
import com.cognizant.springlearn.exception.CountryNotFoundException;

@Service
public class CountryService {
	

	public Country getCountry(String code) throws CountryNotFoundException
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		ArrayList<Country> countries =(ArrayList<Country>) context.getBean("countryList");
		
		Country c = null;
		
		c = countries.stream().filter(x->x.getCode().contentEquals(code)).findFirst().orElse(null);
		
		
		if(c==null)
		{
			throw new CountryNotFoundException();
		}
		return c;
	}
}

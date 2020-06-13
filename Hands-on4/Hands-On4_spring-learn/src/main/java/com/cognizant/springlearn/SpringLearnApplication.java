package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ComponentScan({"com.cognizant.springlearn.controller","com.cognizant.springlearn.service","com.cognizant.springlearn.dao","com.cognizant.springlearn.exception"})
@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate();
		displayCountry();
		displayCountries();
	}
	
	public static void displayDate()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		
		SimpleDateFormat format = context.getBean("dateFormat",SimpleDateFormat.class);
		
		Date date= null;
		try 
		{
			date = format.parse("31/12/2018");
		} 
		catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LOGGER.debug("Date :{}",date);
		LOGGER.info("END");
		
	}
	
	public static void displayCountry()
	{
		LOGGER.info("START");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("country",Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		
		LOGGER.debug("Country:{}",country.toString());
		LOGGER.debug("Country:{}",anotherCountry.toString());
		LOGGER.info("END");
	}
	
	public static void displayCountries()
	{
		LOGGER.info("START");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		
		ArrayList<Country> countries =(ArrayList<Country>) context.getBean("countryList");
		
		LOGGER.debug("Countries:{}",countries);
		LOGGER.info("END");
		
	}
	

	
	

}

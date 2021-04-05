package com.cognizant.springlearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.springlearn.Country.Country;

@SuppressWarnings("resource")
@SpringBootApplication
public class SpringLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringLearnApplication.class);
	
	/**
	 *   Parsing String date using SimpleDateFormat class object from xml config
	 * @throws ParseException
	 */
	public static void displayDate() throws ParseException
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
		SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
		
		Date date=format.parse("31/12/2018");
		//System.out.println(date);
		LOGGER.debug("Date: {}",date);
		LOGGER.info("END");

	}
	
	/**
	 *  Singleton / Prototype scope testing
	 */
	public static void displayCountry()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("country", Country.class);
		Country anotherCountry = context.getBean("country", Country.class);
		LOGGER.debug("Country : {}", country.toString());
		LOGGER.debug("Country : {}", country.hashCode());
		LOGGER.debug("Another Country : {}", anotherCountry.hashCode());
		LOGGER.info("END");
	}
	
	/**
	 *    printing List of countries from countryList bean
	 */
	public static void displayCountries()
	{
		LOGGER.info("START");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList",List.class);
		for(Country c:countries)
		{
			LOGGER.debug("Country: {}",c);
		}
		LOGGER.info("END");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		try {
			displayDate();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		displayCountry();
		displayCountries();
	}

}

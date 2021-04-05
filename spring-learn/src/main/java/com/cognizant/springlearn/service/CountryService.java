package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springlearn.Country.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	List<Country> countries = context.getBean("countryList", List.class);

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryService.class);

	public Country getCountry(String code) throws CountryNotFoundException {
		LOGGER.info("country service start");
		Country country;

		country = countries.stream().filter(c -> c.getCode().equals(code)).findAny()
				.orElseThrow(CountryNotFoundException::new);

		LOGGER.info("country service end");
		return country;
	}

}

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springlearn.Country.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@SuppressWarnings("resource")
@RestController
public class CountryController {

	@Autowired
	public CountryService countryService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String sayHello() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return "Hello World!!";
	}

	@RequestMapping(value = "/country", method = RequestMethod.GET)
	public Country getCountryIndia() {
		LOGGER.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = context.getBean("in", Country.class);
		LOGGER.info("end");
		return country;
	}

	@GetMapping(value = "/countries")
	public List<Country> getAllCountries() {
		LOGGER.info("start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries = context.getBean("countryList", ArrayList.class);
		LOGGER.info("end");
		return countries;
	}

	@GetMapping(value = "/countries/{code}")
	public Country getCountry(@PathVariable String code) throws CountryNotFoundException {
		LOGGER.info("start");
		Country country = countryService.getCountry(code);
		LOGGER.info("end");
		return country;
	}

	// ---------------------------------------------------------------------

//	@PostMapping(value = "/countries")
//	public Country addCountry(@RequestBody @Valid Country country) {
//		LOGGER.info("start");
//		// Create validator factory
//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//
//		// Validation is done against the annotations defined in country bean
//		Set<ConstraintViolation<Country>> violations = validator.validate(country);
//		List<String> errors = new ArrayList<String>();
//
//		// Accumulate all errors in an ArrayList of type String
//		for (ConstraintViolation<Country> violation : violations) {
//			errors.add(violation.getMessage());
//		}
//
//		// Throw exception so that the user of this web service receives appropriate
//		// error message
//
//		if (violations.size() > 0) {
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());
//		}
//		else
//		{
//		  return country;
//		}
//	}
	
	@PostMapping(value = "/countries")
	public Country addCountry(@RequestBody @Valid Country country) {
		LOGGER.info("start addcountry");
		  return country;
	}

}

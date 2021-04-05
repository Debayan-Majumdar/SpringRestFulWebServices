package com.cognizant.springlearn.Country;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

	public Country() {
		super();
		LOGGER.debug("“Inside Country Constructor");
	}

	public String getCode() {
		LOGGER.info("getting country code");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("setting country code");
		this.code = code;
	}

	public String getName() {
		LOGGER.info("getting country name");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("setting country name");
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}

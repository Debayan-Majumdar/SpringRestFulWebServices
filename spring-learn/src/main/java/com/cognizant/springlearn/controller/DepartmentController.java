package com.cognizant.springlearn.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.empoyee.Department;
import com.cognizant.springlearn.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@GetMapping(value = "/departments")
	public List<Department> getAllDepartments()
	{
		LOGGER.info("inside getAllDepartments");
		return departmentService.getAllDepartments();
	}
	
}

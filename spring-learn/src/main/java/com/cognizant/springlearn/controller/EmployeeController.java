package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.empoyee.Employee;
import com.cognizant.springlearn.service.EmployeeService;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
        
		LOGGER.info("inside getAllEmployees");
		return employeeService.getAllEmployees();
	}
	
	@PutMapping(value = "/updateEmployee")
	public void updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("inside updateEmployee");
		employeeService.updateEmployee(employee);
		LOGGER.debug("Employees: {}",employeeService.getAllEmployees());
		LOGGER.info("end");
	}
	
	@DeleteMapping(value = "/deleteEmployee/{id}")
	public void deleteEmployee(@RequestBody @Valid Employee employee, @PathVariable int id) throws EmployeeNotFoundException
	{
		LOGGER.info("inside deleteEmployee");
		employeeService.deleteEmployee(id);
		LOGGER.info("end");
	}

}

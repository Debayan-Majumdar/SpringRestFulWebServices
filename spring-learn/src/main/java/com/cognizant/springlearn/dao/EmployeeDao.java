package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.empoyee.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Component
public class EmployeeDao {

	private static final Logger LOGGER=LoggerFactory.getLogger(EmployeeDao.class);
	
	private static ArrayList<Employee> EMPLOYEE_LIST;
	
	ApplicationContext cpxac=new ClassPathXmlApplicationContext("employee.xml");
	
	public EmployeeDao()
	{
		LOGGER.info("inside EmployeeDao constructor");
		EMPLOYEE_LIST = cpxac.getBean("employeeList",ArrayList.class);
		LOGGER.debug("EMPLOYEE_LIST {}",EMPLOYEE_LIST);
	}
	
	public List<Employee> getAllEmployees()
	{
		return EMPLOYEE_LIST;
	}
	
	public void updateEmployee(Employee employee) throws EmployeeNotFoundException
	{
		LOGGER.info("update employee");
		
		for(Employee emp:EMPLOYEE_LIST)
		{
			if(emp.getEmpid()==employee.getEmpid())
			{
				EMPLOYEE_LIST.remove(emp);
				EMPLOYEE_LIST.add(employee);
				return;
			}
		}
		
		throw new EmployeeNotFoundException();
		
	}
	
	public void deleteEmployee(int id) throws EmployeeNotFoundException
	{
		LOGGER.info("delete employee");
		
		Employee employee = EMPLOYEE_LIST.stream().filter(e->e.getEmpid()==id).findAny().orElseThrow(()-> new EmployeeNotFoundException());
		EMPLOYEE_LIST.remove(employee);
		LOGGER.info("end");
		
	}
	
}

package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.springlearn.empoyee.Department;

@Component
public class DepartmentDao {

	private static List<Department> DEPARTMENT_LIST;
	
	ApplicationContext cpxac=new ClassPathXmlApplicationContext("employee.xml");
	
	public DepartmentDao()
	{
		DEPARTMENT_LIST=cpxac.getBean("departmentList",ArrayList.class);
	}
	
	public List<Department> getAllDepartments()
	{
		return DEPARTMENT_LIST;
	}
	
}

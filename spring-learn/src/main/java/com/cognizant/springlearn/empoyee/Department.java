package com.cognizant.springlearn.empoyee;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class Department {

	@NotNull
	@NumberFormat(style = Style.NUMBER)
	private int deptid;
	
	@NotNull
	@Size(min = 1,max = 30)
	private String name;
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

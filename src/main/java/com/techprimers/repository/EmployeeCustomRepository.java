package com.techprimers.repository;

import java.util.List;

import com.techprimers.model.Employee;

public interface EmployeeCustomRepository {
	public List<Employee> getEmployeeDetails();
	
	public List<Object[]> getEmployeeFullDetails();
	
}

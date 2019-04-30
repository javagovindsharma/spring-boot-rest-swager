package com.techprimers.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techprimers.model.Employee;
import com.techprimers.repository.EmployeeCustomRepository;
import com.techprimers.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeCustomRepository employeeCustomRepository;

	public List<Employee> getAllEmployeeService() {
		logger.info(getClass().getName()+"  invked getAllEmployee");
		List<Employee> empRecords = new ArrayList<>();
		empRecords = employeeRepository.findAll();
		return empRecords;
	}

	public Employee getEmployeeByIdService(String id) {
		return employeeRepository.findOne(id);
	}
	
	
	
	public List<Employee> getCustomEmpl(){
	  return employeeCustomRepository.getEmployeeDetails();
	}
	
	public List<Object[]> getEmployeeWithJOInS(){
		return employeeCustomRepository.getEmployeeFullDetails();
	} 
	
	
	
	public void addEmployeeService(Employee userRecord) {
		employeeRepository.save(userRecord);
	}

	public void deleteEmployeeService(String id) {
		employeeRepository.delete(id);
	}
	
	public void updateEmplyeeService(Employee employee) {
		Employee empGetRecords=employeeRepository.findOne(String.valueOf(employee.getEmployeeNumber()));
		empGetRecords.setEmail(employee.getEmail());
		empGetRecords.setExtension(employee.getExtension());
		empGetRecords.setFirstName(employee.getFirstName());
		empGetRecords.setJobTitle(employee.getJobTitle());
		empGetRecords.setLastName(employee.getLastName());
		empGetRecords.setOfficeCode(employee.getOfficeCode());
		empGetRecords.setReportsTo(employee.getReportsTo());
		employeeRepository.save(empGetRecords);
		
		
	}
}

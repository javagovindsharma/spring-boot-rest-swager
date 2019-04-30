package com.techprimers.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.techprimers.model.Employee;
import com.techprimers.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	
     private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/all")
	public List<Employee> getAllEmplpyee(HttpServletRequest request,HttpServletResponse response) {
		logger.info("get All Employeee");
		return employeeService.getAllEmployeeService();
	}

	@PostMapping(value = "/add-employee")
	public void addEmployee(@RequestBody Employee empRecord) {
		employeeService.addEmployeeService(empRecord);
	}
	
	@PostMapping(value = "/get/{id}")
	public Employee getEmployeeById(@PathVariable String id) {
		return employeeService.getEmployeeByIdService(id);
	}
	
	@PostMapping(value = "/delete/{id}")
	public void deleteById(@PathVariable String id) {
		 employeeService.deleteEmployeeService(id);
	}
	
	@PostMapping(value = "/update-employee")
	public void updateEmployee(@RequestBody Employee empRecord) {
		employeeService.updateEmplyeeService(empRecord);
	}
	
	@GetMapping("/govind")
	public List<Employee> getCustomEmployes(){
		return employeeService.getCustomEmpl();
	}
	
	@GetMapping("/govindJoin")
	public List<Object[]> getEmployeeJoin(){
		return employeeService.getEmployeeWithJOInS();
	}
	
}

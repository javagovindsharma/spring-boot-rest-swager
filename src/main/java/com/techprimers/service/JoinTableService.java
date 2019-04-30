package com.techprimers.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techprimers.model.Employee;
import com.techprimers.repository.JoinTableRepository;

@Service
public class JoinTableService {

	
	  @Autowired
	  private JoinTableRepository  joinTableRepository;
	  
	  
	  public List<Employee> getAllEmployeeWithOfficeService() {
			return joinTableRepository.getEmployeeWithOffice();
		}
}

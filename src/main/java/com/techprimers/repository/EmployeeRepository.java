package com.techprimers.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import com.techprimers.model.Employee;

@Component
public interface EmployeeRepository extends JpaRepository<Employee, String>{


	
}

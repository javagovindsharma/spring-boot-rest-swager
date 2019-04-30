package com.techprimers.repository;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import com.techprimers.model.Employee;

@Component
public interface JoinTableRepository extends JpaRepository<Employee, Serializable> {

	@Modifying
	@Transactional
	@Query("SELECT lastName,firstName,extension,email,officeCode,reportsTo,jobTitle FROM Employee   ")
	public List<Employee> getEmployeeWithOffice();

}

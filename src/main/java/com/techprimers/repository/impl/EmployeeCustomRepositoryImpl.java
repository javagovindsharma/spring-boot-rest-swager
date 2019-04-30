package com.techprimers.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.techprimers.model.Employee;
import com.techprimers.repository.EmployeeCustomRepository;

@Repository
@Transactional
public class EmployeeCustomRepositoryImpl implements EmployeeCustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeDetails() {
	   return (List<Employee>) entityManager.createQuery("  from Employee ").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getEmployeeFullDetails() {
		
		String QUERY="select emp.*   from employees emp inner join  offices  ofs on emp.officeCode=ofs.officeNumber ";
		return entityManager.createNativeQuery(QUERY).getResultList();
	}

}

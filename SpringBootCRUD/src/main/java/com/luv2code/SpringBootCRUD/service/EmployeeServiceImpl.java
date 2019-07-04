package com.luv2code.SpringBootCRUD.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.SpringBootCRUD.dao.EmployeeRepositorySpringJpa;
import com.luv2code.SpringBootCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepositorySpringJpa employeeRepositorySpringJpa;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepositorySpringJpa employeeRepositorySpringJpa) {
		this.employeeRepositorySpringJpa = employeeRepositorySpringJpa;
	}

	@Override

	public List<Employee> getALl() {

		return employeeRepositorySpringJpa.findAll();
	}

	@Override

	public Employee getById(int theId) {

		Optional<Employee> result = employeeRepositorySpringJpa.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		} else {
			throw new RuntimeException("EMployee is not found of ID : " + theId);
		}
		return theEmployee;
	}

	@Override

	public void saveEmployee(Employee theEmployee) {

		employeeRepositorySpringJpa.save(theEmployee);
	}

	@Override

	public void deleteById(int theId) {

		employeeRepositorySpringJpa.deleteById(theId);
	}

}

package com.luv2code.SpringBootCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.SpringBootCRUD.dao.EmployeeDAO;
import com.luv2code.SpringBootCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;

	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	@Transactional
	public List<Employee> getALl() {

		return employeeDAO.getALl();
	}

	@Override
	@Transactional
	public Employee getById(int theId) {

		return employeeDAO.getById(theId);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {

		employeeDAO.saveEmployee(theEmployee);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {

		employeeDAO.deleteById(theId);
	}

}

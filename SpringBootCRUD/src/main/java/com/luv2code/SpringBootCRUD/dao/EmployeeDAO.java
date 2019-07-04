package com.luv2code.SpringBootCRUD.dao;

import java.util.List;

import com.luv2code.SpringBootCRUD.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> getALl();
	
	public Employee getById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteById(int theId);
}

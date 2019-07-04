package com.luv2code.SpringBootCRUD.service;

import java.util.List;

import com.luv2code.SpringBootCRUD.entity.Employee;

public interface EmployeeService {
	
public List<Employee> getALl();
	
	public Employee getById(int theId);
	
	public void saveEmployee(Employee theEmployee);
	
	public void deleteById(int theId);

}

package com.luv2code.SpringBootCRUD.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.SpringBootCRUD.entity.Employee;
import com.luv2code.SpringBootCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	@Autowired
	private EmployeeService employeeservice;
	
	@GetMapping("/employees")
	public List<Employee> getAll(){
		return employeeservice.getALl();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId){
		
		Employee theEmployee = employeeservice.getById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee ID not found : "+ employeeId);
		}
		return theEmployee;
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@RequestBody Employee theEmployee){
		theEmployee.setId(0);
		employeeservice.saveEmployee(theEmployee);
		return theEmployee;
	}
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		employeeservice.saveEmployee(theEmployee);
		return theEmployee;
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId){
		Employee theEmployee = employeeservice.getById(employeeId);
		if(theEmployee == null) {
			throw new RuntimeException("Employee ID not found : "+ employeeId);
		}
		 employeeservice.deleteById(employeeId);
       return "Employee Deleted : "+ employeeId;		
	}	
}

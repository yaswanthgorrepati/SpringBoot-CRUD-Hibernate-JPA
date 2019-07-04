package com.luv2code.SpringBootCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2code.SpringBootCRUD.entity.Employee;

public interface EmployeeRepositorySpringJpa extends JpaRepository<Employee, Integer> {

}

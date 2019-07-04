package com.luv2code.SpringBootCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.SpringBootCRUD.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJPAImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getALl() {
		Query theQuery = entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees = theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee);
		theEmployee.setId(dbEmployee.getId());

	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id =: employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}

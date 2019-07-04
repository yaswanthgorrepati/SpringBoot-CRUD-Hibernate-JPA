package com.luv2code.SpringBootCRUD.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.SpringBootCRUD.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> getALl() {
		Session currentSession = entityManager.unwrap(Session.class);

		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);

		List<Employee> employee = theQuery.getResultList();
		return employee;
	}

	@Override
	public Employee getById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee theEmployee = currentSession.get(Employee.class, theId);;
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id =: employeeId");
      theQuery.setParameter("employeeId", theId);
      theQuery.executeUpdate();
	}

}













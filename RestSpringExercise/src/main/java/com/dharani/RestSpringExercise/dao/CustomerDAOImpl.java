package com.dharani.RestSpringExercise.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.dharani.RestSpringExercise.Entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Customer> getCustomers() {
		Session CurrentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = CurrentSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);

	}

	public Customer getCustomer(int theId) {

		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;

	}

	public void deleteCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);
		query.executeUpdate();

	}

}

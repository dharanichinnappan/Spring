package com.dharani.RestSpringExercise.dao;

import java.util.List;

import com.dharani.RestSpringExercise.Entity.Customer;



public interface CustomerDAO {

	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer (int theId);
	public void deleteCustomer(int theId);
}

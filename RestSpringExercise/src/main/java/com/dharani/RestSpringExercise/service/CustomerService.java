package com.dharani.RestSpringExercise.service;

import java.util.List;

import com.dharani.RestSpringExercise.Entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);

}

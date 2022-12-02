package com.anshu.basic.dao;

import java.util.List;

import com.anshu.basic.model.Customer;

public interface CustomerDAO {
	public String addCustomerRecord(Customer customer);
	
	public String updateCustomerRecord(Customer customer);
	
	public String removeCustomerRecord(Integer customerId);
	
	public List<Customer> findCustomerRecordById(Integer customerId);
	public List<Customer> findCustomerRecordByName(String customerName);
	public List<Customer> findCustomerRecordByEmail(String customerEmail);
	public List<Customer> findCustomerRecordByMobileNo(String customerMobileNo);
	public List<Customer> findAllCustomerRecord();

}

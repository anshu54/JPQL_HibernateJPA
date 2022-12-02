package com.anshu.basic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.anshu.basic.model.Customer;

public class CustomerDAOImp implements CustomerDAO {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager 		entityManager;
	private static EntityTransaction 	entityTransaction;
	
	static
	{
		entityManagerFactory=Persistence.createEntityManagerFactory("anshu");
		entityManager		=entityManagerFactory.createEntityManager();
		entityTransaction	=entityManager.getTransaction();
	}
	

	@Override
	public String addCustomerRecord(Customer customer) {
	entityTransaction.begin();
		entityManager.persist(customer);
	entityTransaction.commit();
	return "Customer Record Added..";
	}

	@Override
	public String updateCustomerRecord(Customer customer) {
		String jpql="update Customer c set c.customerName=?1,c.customerDOB=?2,c.customerGender=?3,c.customerEmail=?4,c.customerMobileNo=?5,c.customerAddress=?6 where c.customerId=?7";
	
		Query query=entityManager.createQuery(jpql);
		
		query.setParameter(1,customer.getCustomerName() );
		query.setParameter(2, customer.getCustomerDOB());
		query.setParameter(3, customer.getCustomerGender());
		query.setParameter(4, customer.getCustomerEmail());
		query.setParameter(5, customer.getCustomerMobileNo());
		query.setParameter(6, customer.getCustomerAddress());
		query.setParameter(7, customer.getCustomerId());

		entityTransaction.begin();
		Integer x=query.executeUpdate();
		entityTransaction.commit();
		
		return x+" Record Updated...";
	}

	@Override
	public String removeCustomerRecord(Integer customerId) {
		String jpql="delete from Customer c where c.customerId=?1";
		Customer customer=entityManager.find(Customer.class, customerId);
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, customer.getCustomerId());
		entityTransaction.begin();
		Integer x=query.executeUpdate();
		entityTransaction.commit();
		
		return x+" Record Deleted..";
	}

	@Override
	public List<Customer> findAllCustomerRecord() {
		String jpql="select c from Customer c";
		Query query=entityManager.createQuery(jpql);
		List<Customer> listC=query.getResultList();
		
		return listC;
	}

	@Override
	public List<Customer> findCustomerRecordById(Integer customerId) {
		String jpql="select c from Customer c where customerId=?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, customerId);
		
		List<Customer> res=query.getResultList();
		return  res;
	}

	@Override
	public List<Customer> findCustomerRecordByName(String customerName) {
		String jpql="select c from customer c where customerName=?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, customerName);
		
		List<Customer> res=query.getResultList();
		return res;
	}

	@Override
	public List<Customer> findCustomerRecordByEmail(String customerEmail) {
		String jpql="select c from Customer c where customerEmail=?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, customerEmail);
		
		List<Customer> res=query.getResultList();
		return res;
	}

	@Override
	public List<Customer> findCustomerRecordByMobileNo(String customerMobileNo) {
		String jpql="select c from Customer c where customerMobileNo=?1";
		
		Query query=entityManager.createQuery(jpql);
		query.setParameter(1, customerMobileNo);
		
		List<Customer> res=query.getResultList();
		return res;
	}
	
	


}

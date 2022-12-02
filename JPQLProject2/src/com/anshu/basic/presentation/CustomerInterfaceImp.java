package com.anshu.basic.presentation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.anshu.basic.dao.CustomerDAOImp;
import com.anshu.basic.model.Customer;
import com.anshu.basic.validation.Validation;

public class CustomerInterfaceImp implements CustomerInterface {
	private Scanner scanner=new Scanner(System.in);
	private CustomerDAOImp customerDAOImp=new CustomerDAOImp();
	private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
	
	private Integer customerId;
	private String customerName;
	private Date customerDOB;
	private String customerGender;
	private String customerEmail;
	private String customerMobileNo;
	private String customerAddress;
	private String dob;
	private Boolean checkingName;
	private Boolean checkingGender;
	private Boolean checkingEmail;
	private Boolean checkingMobileNo;
	private Boolean checkingDateOfBirth;
	
	
	@Override
	public void addCustomerRecord()
	{
		Customer customer=new Customer();
		
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingMobileNo=true;
		checkingDateOfBirth=true;
		
		while(checkingName)
		{
			
			System.out.print("Enter Customer Name : ");
			customerName=scanner.nextLine();
			if(Validation.checkNameLength(customerName))
			{
				if(Validation.validateString(customerName))
				{
					customer.setCustomerName(customerName);
					checkingName=false;
					while(checkingDateOfBirth)
					{
						System.out.print("Enter Customer Data of Birth : ");
						dob=scanner.next();
						if(Validation.checkDate(dob,new Date())) 
						{
							try 
							{
							customerDOB=simpleDateFormat.parse(dob);
							} catch (ParseException e) {
								System.out.println(e);
								}
							customer.setCustomerDOB(customerDOB);
							checkingDateOfBirth=false;
							while(checkingGender)
							{
								System.out.print("Enter Customer Gender : ");
								customerGender=scanner.next();
								if(Validation.checkGender(customerGender))
								{
									customer.setCustomerGender(customerGender);
									checkingGender=false;
									while(checkingEmail)
									{
										System.out.print("Enter Customer E-mail Id : ");
										customerEmail=scanner.next();
										if(Validation.checkEmail(customerEmail))
										{
											customer.setCustomerEmail(customerEmail);
											checkingEmail=false;
											while(checkingMobileNo)
											{
												System.out.print("Enter Customer Mobile Number : ");
												customerMobileNo=scanner.next();
												if(Validation.checkMobileNumber(customerMobileNo))
												{
													customer.setCustomerMobileNo(customerMobileNo);
													checkingMobileNo=false;
													System.out.print("Enter Customer Address : ");
													customerAddress=scanner.nextLine();
													customerAddress=scanner.nextLine();
													customer.setCustomerAddress(customerAddress);
													
													System.out.println("\n"+customerDAOImp.addCustomerRecord(customer)+"\n");
												}
												else
												{
												System.out.println("\nInvalid Mobile Number..\n");
												}
											}
										}
										else
										{
										System.out.println("\nInvalid Email...\n");
										}
									}
								}
								else
								{
									System.out.println("\nInvalid Gender.\n");
								}
							}
						}
					else
						{
						System.out.println("\nInvalid date format... Enter Date of Birth [MM/dd//yyyy] Format Only...\n");
								
						}
					}
				}
				else
				{
				System.out.println("\nCustomer name must be letters...\n");
				}		
			}
			else
			{
			System.out.println("\nCustomer name length must be less then 15 ...\n");
			}
		}
		
	}

	@Override
	public void updateCustomerRecord() {
		
		checkingName=true;
		checkingGender=true;
		checkingEmail=true;
		checkingMobileNo=true;
		checkingDateOfBirth=true;
		
		Customer customer=new Customer();
		System.out.print("Enter Customer Id : ");
		customerId=scanner.nextInt();
		
		
		List<Customer> lObj=customerDAOImp.findCustomerRecordById(customerId);
		if(lObj.size()!=0)
		{
		
		customer.setCustomerId(customerId);
		while(checkingName)
		{
			System.out.print("Enter Customer Name : ");
			customerName=scanner.next();
			customerName=scanner.nextLine();
			if(Validation.checkNameLength(customerName))
			{
				if(Validation.validateString(customerName))
				{
					customer.setCustomerName(customerName);
					checkingName=false;
					while(checkingDateOfBirth)
					{
						System.out.print("Enter Customer Data of Birth : ");
						dob=scanner.next();
						if(Validation.checkDate(dob,new Date())) 
						{
							try 
							{
							customerDOB=simpleDateFormat.parse(dob);
							} catch (ParseException e) {
								System.out.println(e);
								}
							customer.setCustomerDOB(customerDOB);
							checkingDateOfBirth=false;
							while(checkingGender)
							{
								System.out.print("Enter Customer Gender : ");
								customerGender=scanner.next();
								if(Validation.checkGender(customerGender))
								{
									customer.setCustomerGender(customerGender);
									checkingGender=false;
									while(checkingEmail)
									{
										System.out.print("Enter Customer E-mail Id : ");
										customerEmail=scanner.next();
										if(Validation.checkEmail(customerEmail))
										{
											customer.setCustomerEmail(customerEmail);
											checkingEmail=false;
											while(checkingMobileNo)
											{
												System.out.print("Enter Customer Mobile Number : ");
												customerMobileNo=scanner.next();
												if(Validation.checkMobileNumber(customerMobileNo))
												{
													customer.setCustomerMobileNo(customerMobileNo);
													checkingMobileNo=false;
													System.out.print("Enter Customer Address : ");
													customerAddress=scanner.nextLine();
													customerAddress=scanner.nextLine();
													customer.setCustomerAddress(customerAddress);
													
													System.out.println("\n"+customerDAOImp.updateCustomerRecord(customer)+"\n");
											
												}
												else
												{
												System.out.println("\nInvalid Mobile Number..\n");
												}
											}
										}
										else
										{
										System.out.println("\nInvalid Email...\n");
										}
									}
								}
								else
								{
									System.out.println("\nInvalid Gender.\n");
								}
							}
						}
					else
						{
						System.out.println("\nInvalid date format... Enter Date of Birth [MM/dd//yyyy] Format Only...\n");
								
						}
					}
				}
				else
				{
				System.out.println("\nCustomer name must be letters...\n");
				}		
			}
			else
			{
			System.out.println("\nCustomer name length must be less then 15 ...\n");
			}
		}
		
	}
	else
	{
		System.out.println("\n Record Not Found..");
	}

	}

	@Override
	public void removeCustomerRecord() {
		System.out.print("\nEnter Customer Id :");
		customerId=scanner.nextInt();
		List<Customer> lObj=customerDAOImp.findCustomerRecordById(customerId);
		if(lObj.size()!=0)
		{
			System.out.println("\n"+customerDAOImp.removeCustomerRecord(customerId)+"\n");
		}
		else
		{
			System.out.println("\n Record Not Found..");
		}

	}

	@Override
	public void findCustomerRecordById() {
		System.out.print("\nEnter Customer Id: ");
		customerId=scanner.nextInt();
		try {
		List<Customer> lObj=customerDAOImp.findCustomerRecordById(customerId);
		
		Iterator<Customer> itr=lObj.iterator();
		
			Customer c=itr.next();
			System.out.println("---------------------------------------------");
			System.out.println("Customer No is 			: "+c.getCustomerId());
			System.out.println("Customer Name is 		: "+c.getCustomerName());
			System.out.println("Customer Salary is 		: "+c.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+c.getCustomerGender());
			System.out.println("Customer Email is 		: "+c.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+c.getCustomerMobileNo());
			System.out.println("Customer Address is 		: "+c.getCustomerAddress());
			System.out.println("----------------------------------------------");
		
	}catch(NoSuchElementException e) {
			System.out.println("\n Record Not Found");
	}
	}

	@Override
	public void findAllCustomerRecord() {
		List<Customer> customerList=customerDAOImp.findAllCustomerRecord();
		Iterator<Customer> li=customerList.iterator();
		System.out.println("**********************************************************************************************");
		System.out.println("customerId\tName\t\tDateOfBirth\tGender\tEmail\t\t\tMobileNo\tAddress");
		while(li.hasNext())
		{
			Customer c=li.next();
			System.out.println(c.getCustomerId()+"\t\t"+c.getCustomerName()+"\t"+c.getCustomerDOB()+"\t"+c.getCustomerGender()+"\t"+c.getCustomerEmail()+"\t"+c.getCustomerMobileNo()
			+"\t"+c.getCustomerAddress());
		}
		System.out.println("***********************************************************************************************");
		

	}

	@Override
	public void findCustomerRecordByName() {
		System.out.print("\nEnter Customer Name: ");
		customerName=scanner.nextLine();
		customerName=scanner.nextLine();

		List<Customer> lObj=customerDAOImp.findCustomerRecordByName(customerName);
		if(lObj.size()!=0) {
		Iterator<Customer> itr=lObj.iterator();
		while(itr.hasNext())
		{
			Customer c=itr.next();
			System.out.println("------------------------------------------");
			System.out.println("Customer No is 			: "+c.getCustomerId());
			System.out.println("Customer Name is 		: "+c.getCustomerName());
			System.out.println("Customer Salary is 		: "+c.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+c.getCustomerGender());
			System.out.println("Customer Email is 		: "+c.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+c.getCustomerMobileNo());
			System.out.println("Customer Address is 		: "+c.getCustomerAddress());
			System.out.println("----------------------------------------------");
		}
		}
		else
		{
			System.out.println("\n Record Not Found");
		}
	}
		
	

	@Override
	public void findCustomerRecordByEmail() {
		System.out.print("\nEnter Customer Email: ");
		customerEmail=scanner.next();
		try {
		List<Customer> lObj=customerDAOImp.findCustomerRecordByEmail(customerEmail);
		Iterator<Customer> itr=lObj.iterator();
		
			Customer c=itr.next();
			System.out.println("--------------------------------------------");
			System.out.println("Customer No is 			: "+c.getCustomerId());
			System.out.println("Customer Name is 		: "+c.getCustomerName());
			System.out.println("Customer Salary is 		: "+c.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+c.getCustomerGender());
			System.out.println("Customer Email is 		: "+c.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+c.getCustomerMobileNo());
			System.out.println("Customer Address is 		: "+c.getCustomerAddress());
			System.out.println("----------------------------------------------");
		
		}catch(NoSuchElementException e) {
			System.out.println("\n Record Not Found");
		}
	}
		
	

	@Override
	public void findCustomerRecordByMobileNo() {
		System.out.print("\nEnter Customer Mobile Number: ");
		customerMobileNo=scanner.next();
		List<Customer> lObj=customerDAOImp.findCustomerRecordByMobileNo(customerMobileNo);
		
		Iterator<Customer> itr=lObj.iterator();
		if(itr!=null) {
			Customer c=itr.next();
			System.out.println("--------------------------------------------");
			System.out.println("Customer No is 			: "+c.getCustomerId());
			System.out.println("Customer Name is 		: "+c.getCustomerName());
			System.out.println("Customer Salary is 		: "+c.getCustomerDOB());
			System.out.println("Customer Gender is 		: "+c.getCustomerGender());
			System.out.println("Customer Email is 		: "+c.getCustomerEmail());
			System.out.println("Customer Mobile Number is 	: "+c.getCustomerMobileNo());
			System.out.println("Customer Address is 		: "+c.getCustomerAddress());
			System.out.println("-----------------------------------------------");
		}
		else {
			System.out.println("\n Record Not Found");
		}
	}
		
	
	

}

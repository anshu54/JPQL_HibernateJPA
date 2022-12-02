package com.anshu.basic.presentation;
import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		CustomerInterfaceImp userInterfaceImp=new CustomerInterfaceImp();
		Integer choice=null;
		do
		{
			System.out.println("\n***********************************");
			System.out.println("     Customer Information    ");
			System.out.println("***********************************");
		
			System.out.println("1. Add 	Customer Record.    ");
			System.out.println("2. Update Customer Record.  ");
			System.out.println("3. Delete Customer Record.  ");
			System.out.println("4. Find Customer Record.    ");
			System.out.println("5. Find All Customer Record.");
			System.out.println("6. Exit.");
		
			System.out.print("\nEnter your Choice : ");
			choice=scanner.nextInt();
			System.out.println("--------------------");
		
		switch(choice)
		{
			case 1:
				userInterfaceImp.addCustomerRecord();
				break;
			case 2:
				userInterfaceImp.updateCustomerRecord();
				break;
			case 3:
				userInterfaceImp.removeCustomerRecord();
				break;
			case 4:
				do {
					System.out.println("\n*******************************");
					System.out.println("    Find Customer Record :    ");
					System.out.println("********************************");
					
					System.out.println("1. Find By Customer Id.                ");
					System.out.println("2. Find By Customer Name.              ");
					System.out.println("3. Find By Customer Email.             ");
					System.out.println("4. Find By Customer Mobile Number.     ");
					System.out.println("5. Exit ");
				
					System.out.print("Enter any option :");
					Integer option=scanner.nextInt();
					System.out.println("-----------------");
					switch(option)
					{
						case 1:
							userInterfaceImp.findCustomerRecordById();
							
							break;
						case 2:
							userInterfaceImp.findCustomerRecordByName();
							break;
						case 3:
							userInterfaceImp.findCustomerRecordByEmail();
							break;
						case 4:
							userInterfaceImp.findCustomerRecordByMobileNo();
							break;
						case 5:
							System.out.println("\nExit.");
							break;
						default:
							System.out.println("Invalid Number.");
					}
				}while(choice==5);
				break;
			case 5:
				userInterfaceImp.findAllCustomerRecord();
				break;
			case 6:
				System.out.println("User does not want to continue... ");
				break;
			default:
				System.out.println("Invalid Number...");
		}
	}while(choice!=6);
		scanner.close();

	}

}

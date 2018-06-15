package com.cg.banking.main;

import java.util.Scanner;

import com.cg.banking.exceptions.AccountBlockedException;
import com.cg.banking.exceptions.AccountNotFoundException;
import com.cg.banking.exceptions.BankingServicesDownException;
import com.cg.banking.exceptions.CustomerNotFoundException;
import com.cg.banking.exceptions.InsufficientAmountException;
import com.cg.banking.exceptions.InvalidAccountTypeException;
import com.cg.banking.exceptions.InvalidAmountException;
import com.cg.banking.exceptions.InvalidPinNumberException;
import com.cg.banking.services.BankingServices;
import com.cg.banking.services.BankingServicesImpl;


public class MainClass {
	public static void main(String[] args) {
		BankingServices bankingServies=new BankingServicesImpl();
		Scanner sc=new Scanner(System.in);
		int option=0;
		int customerId,balance;
		long accountNo;
		float amount;
		while(option!=6){
			System.out.println(	"MENU:"+"\n"+
					"1.To accept Customer Details"+"\n"+
					"2.To Open an Account"+"\n"+
					"3.To Generate new Pin"+"\n"+
					"4.To Deposit Amount in an Account"+"\n"+
					"5.To Withdraw Amount in an Account"+"\n"+
					"6.To changeAccountPin"+"\n"+
					"7."+"\n"+
					"8."+"\n"+
					"9."+"\n"+
					"10."+"\n"+
					"11."+"\n"+
					"12."+"\n");
			while(option!=6){
				System.out.println("Enter valid option:");
				option=sc.nextInt();
				switch (option) {
				case 1:
					try {
						System.out.println("enter firstName");
						String firstName=sc.next();
						System.out.println("enter lastName");
						String lastName=sc.next();
						System.out.println("enter customerEmailId");
						String customerEmailId=sc.next();
						System.out.println("enter panCard");
						String panCard=sc.next();
						System.out.println("enter localAddressCity");
						String localAddressCity=sc.next();
						System.out.println("enter localAddressState");
						String localAddressState=sc.next();
						System.out.println("enter localAddressPinCode");
						int localAddressPinCode=sc.nextInt();
						System.out.println("enter homeAddressCity");
						String homeAddressCity=sc.next();
						System.out.println("enter homeAddressState");
						String homeAddressState=sc.next();
						System.out.println("enter homeAddressPinCode");
						int homeAddressPinCode=sc.nextInt();
						customerId=bankingServies.acceptCustomerDetails(firstName, lastName, customerEmailId, panCard, localAddressCity, localAddressState, localAddressPinCode, homeAddressCity, homeAddressState, homeAddressPinCode);
						System.out.println("Created customer Id:"+customerId);
						break;
					} catch (BankingServicesDownException e) {
						e.printStackTrace();
					}
				case 2:System.out.println("Enter customerId");
				customerId=sc.nextInt();
				System.out.println("Enter accountType");
				String accountType=sc.next();
				System.out.println("Enter initBalance");
				balance=sc.nextInt();
				try {
					accountNo=bankingServies.openAccount(customerId, accountType, balance);
					System.out.println("Your Account Number: "+accountNo);
					break;
				} catch (InvalidAmountException | CustomerNotFoundException | InvalidAccountTypeException
						| BankingServicesDownException e) {
					e.printStackTrace();
				}
				case 3:System.out.println("Enter Customer Id");
				customerId=sc.nextInt();
				System.out.println("Enter account Number");
				accountNo=sc.nextLong();
				try {
					int pin=bankingServies.generateNewPin(customerId, accountNo);
					System.out.println("Your pin is:"+pin);
					break;
				} catch (CustomerNotFoundException | AccountNotFoundException | BankingServicesDownException e) {
					e.printStackTrace();
				}
				case 4:System.out.println("To deposit amount");
				System.out.println("Enter Customer Id");
				customerId=sc.nextInt();
				System.out.println("Enter account Number");
				accountNo=sc.nextLong();
				System.out.println("Enter Amount to be Deposited");
				amount=sc.nextFloat();
				try {
					float balance4=bankingServies.depositAmount(customerId, accountNo, amount);
					System.out.println("Balance in "+customerId+" is :"+balance4);
				} catch (CustomerNotFoundException | AccountNotFoundException | BankingServicesDownException
						| AccountBlockedException e) {
					e.printStackTrace();
				}
				case 5:System.out.println("Enter Customer Id");
				customerId=sc.nextInt();
				System.out.println("Enter account Number");
				accountNo=sc.nextLong();
				System.out.println("Enter Amount to be Deposited");
				amount=sc.nextFloat();
				System.out.println("Enter Pin Number");
				int pinNumber5=sc.nextInt();
				try {
					float balance5=bankingServies.withdrawAmount(customerId, accountNo, amount, pinNumber5);
				System.out.println(customerId+" withdrew "+balance5+" from "+accountNo);
				} catch (InsufficientAmountException | CustomerNotFoundException | AccountNotFoundException
						| InvalidPinNumberException | BankingServicesDownException | AccountBlockedException e) {
					e.printStackTrace();
				}
				case 6:
					System.out.println("Enter your Details"+"\n"+"Your customer ID:");
					int customerIdFrom=sc.nextInt();
					System.out.println("Your Account No");
					long accountNoFrom=sc.nextLong();
					System.out.println("Enter your pin Number");
					int pinNumber6=sc.nextInt();
					System.out.println("Enter amount to be transfered");
					float transferAmount=sc.nextFloat();
					System.out.println("Enter details of transferee"+"\n"+"To customerId");
					int customerIdTo=sc.nextInt();
					System.out.println("To account No");
					long accountNoTo=sc.nextLong();
					try {
						boolean balance5=bankingServies.fundTransfer(customerIdTo, accountNoTo, customerIdFrom, accountNoFrom, transferAmount, pinNumber6);
					System.out.println("Transfer to "+accountNoTo+" successful?"+balance5);
					} catch (InsufficientAmountException | CustomerNotFoundException | AccountNotFoundException
							| InvalidPinNumberException | BankingServicesDownException | AccountBlockedException e) {
						e.printStackTrace();
					}
				case 7:System.out.println("Enter Customer Id:");
				customerId=sc.nextInt();
				System.out.println("enter account no.:");
				accountNo=sc.nextLong();
				System.out.println("Enter your Old Pin NUmber:");
				int oldPinNumber=sc.nextInt();
				System.out.println("Enter your New Pin NUmber:");
				int newPinNumber=sc.nextInt();
					try {
					System.out.println("Pin Changed?:"+	bankingServies.changeAccountPin(customerId, accountNo, oldPinNumber, newPinNumber));
					} catch (CustomerNotFoundException | AccountNotFoundException | InvalidPinNumberException
							| BankingServicesDownException e) {
						e.printStackTrace();
					}
				case 8:
				}
			}
		}
	}
}
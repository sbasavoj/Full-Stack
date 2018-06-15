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
		int option=0;
		int customerId,balance,pin;
		long accountNo;
		float amount,finalBalance;
		while(option!=12){
			try{
				Scanner sc=new Scanner(System.in);
				System.out.println(	"MENU:"+"\n"+
						"1.To accept Customer Details"+"\n"+
						"2.To Open an Account"+"\n"+
						"3.To Generate new Pin"+"\n"+
						"4.To Deposit Amount in an Account"+"\n"+
						"5.To Withdraw Amount in an Account"+"\n"+
						"6.To Transfer Fund"+"\n"+
						"7.To change Account Pin Number "+"\n"+
						"8.To get Customer Details"+"\n"+
						"9.To get details of an Account"+"\n"+
						"10."+"\n"+
						"11."+"\n"+
						"12.Exit"+"\n");
				System.out.println("Enter valid option:");
				option=sc.nextInt();
				switch (option) {
				case 1:
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
				case 2:
					System.out.println("Enter customerId");
					customerId=sc.nextInt();
					System.out.println("Enter accountType");
					String accountType=sc.next();
					System.out.println("Enter initBalance");
					balance=sc.nextInt();
					accountNo=bankingServies.openAccount(customerId, accountType, balance);
					System.out.println("Your Account Number: "+accountNo);
					break;
				case 3:
					System.out.println("Enter Customer Id");
					customerId=sc.nextInt();
					System.out.println("Enter account Number");
					accountNo=sc.nextLong();
					pin=bankingServies.generateNewPin(customerId, accountNo);
					System.out.println("Your pin is:"+pin);
					break;
				case 4:
					System.out.println("To deposit amount");
					System.out.println("Enter Customer Id");
					customerId=sc.nextInt();
					System.out.println("Enter account Number");
					accountNo=sc.nextLong();
					System.out.println("Enter Amount to be Deposited");
					amount=sc.nextFloat();
					finalBalance=bankingServies.depositAmount(customerId, accountNo, amount);
					System.out.println("Balance in "+customerId+" is :"+finalBalance);
					break;
				case 5:
					System.out.println("Enter Customer Id");
					customerId=sc.nextInt();
					System.out.println("Enter account Number");
					accountNo=sc.nextLong();
					System.out.println("Enter Amount to be Withdrew");
					amount=sc.nextFloat();
					System.out.println("Enter Pin Number");
					pin=sc.nextInt();
					finalBalance=bankingServies.withdrawAmount(customerId, accountNo, amount, pin);
					System.out.println("Balance in "+customerId+" is :"+finalBalance);	
					break;
				case 6:
					System.out.println("Enter your Details"+"\n"+"Your customer ID:");
					int customerIdFrom=sc.nextInt();
					System.out.println("Your Account No");
					long accountNoFrom=sc.nextLong();
					System.out.println("Enter your pin Number");
					pin=sc.nextInt();
					System.out.println("Enter amount to be transfered");
					float transferAmount=sc.nextFloat();
					System.out.println("Enter details of transferee"+"\n"+"To customerId");
					int customerIdTo=sc.nextInt();
					System.out.println("To account No");
					long accountNoTo=sc.nextLong();
					boolean balance6=bankingServies.fundTransfer(customerIdTo, accountNoTo, customerIdFrom, accountNoFrom, transferAmount, pin);
					System.out.println("Transfer to "+accountNoTo+" successful?"+balance6);
					break;
				case 7:
					System.out.println("Enter Customer Id:");
					customerId=sc.nextInt();
					System.out.println("enter account no.:");
					accountNo=sc.nextLong();
					System.out.println("Enter your Old Pin NUmber:");
					int oldPinNumber=sc.nextInt();
					System.out.println("Enter your New Pin NUmber:");
					int newPinNumber=sc.nextInt();
					System.out.println("Pin Changed?:"+	bankingServies.changeAccountPin(customerId, accountNo, oldPinNumber, newPinNumber));
					break;
				case 8:
					System.out.println("Enter Customer Id:");
					customerId=sc.nextInt();
					System.out.println(bankingServies.getCustomerDetails(customerId));	
					break;
				case 9:
					System.out.println("Enter Customer Id:");
					customerId=sc.nextInt();
					System.out.println("enter account no.:");
					accountNo=sc.nextLong();
					System.out.println(bankingServies.getAccountDetails(customerId, accountNo));
					break;
				case 10:

					break;
				case 11:
					break;
				default:System.out.println("Enter Valid Option");
					break;

				}
				//sc.close();
			}
			catch (BankingServicesDownException  e) {
				e.printStackTrace();
			}
			catch (CustomerNotFoundException e) {
				e.printStackTrace();
			}
			catch (AccountNotFoundException e) {
				e.printStackTrace();
			}
			catch (InvalidAccountTypeException e) {
				e.printStackTrace();
			}
			catch (InvalidAmountException e) {
				e.printStackTrace();
			}
			catch (AccountBlockedException  e) {
				e.printStackTrace();
			}
			catch (InvalidPinNumberException e) {
				e.printStackTrace();
			}
			catch (InsufficientAmountException e) {
				e.printStackTrace();
			}
			/*catch (Exception e) {
				e.printStackTrace();
			}*/
		}
	}
}


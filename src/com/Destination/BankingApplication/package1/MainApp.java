/**
 * 
 */
package com.Destination.BankingApplication.package1;

import java.util.Scanner;

/**
 * 
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\t\t\tWelcome to the banking Application");
		Scanner sc=new Scanner(System.in);
		BankingApp ba=new BankingApp();//load the driver and establish
		System.out.println("1.Register\n"
				+ "2.User login\n"
				+ "3.Admin login\n"
				+ "4.Quit\n");
		System.out.println("Please enter your choice");
		int choice=sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Registration in progress");	
			boolean b=ba.register();
			if(b==true) {
				System.out.println("registered");
			}
			else {
				System.out.println("failed to register try again");
				main(null);
			}
			}
		case 2: {
			System.out.println("login in progress");	
		}
		case 3: {
			Admin a=new Admin();
			System.out.println("\n\t\t\t\tAdmin login");
			System.out.println("Enter the Admin ID: ");
			a.setAdmin_id(sc.next());
			System.out.println("Enter the Admin password: ");
			a.setAdmin_pwd(sc.next());
			
			boolean b=a.validate();
			if(b==true) {
				System.out.println("Admin login successful");
			}
			else
			{
				System.out.println("Admin login failed");
			}
		}
		case 4: {
			System.out.println("logout in progress");	
		}
		default:
		}
	}
}
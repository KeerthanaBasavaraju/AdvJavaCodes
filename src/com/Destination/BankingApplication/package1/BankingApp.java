/**
 * 
 */
package com.Destination.BankingApplication.package1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/**
 * 
 */
public class BankingApp {
	public static Connection con;
	public String custId; 
	public String custName; 
	public int accno; 
	public String password;
	public int balance; 
	public String bankname; 
	public String ifsccode; 
	public String email;
	private PreparedStatement pstmt;
	
	public BankingApp() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection
					("jdbc:mysql://localhost:3306/jdbc_projects","root","Myself@987654321");
		}
		catch (Exception e) {
			e.printStackTrace();
			}
		
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getBankname() {
		return bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	public String getIfsccode() {
		return ifsccode;
	}

	public void setIfsccode(String ifsccode) {
		this.ifsccode = ifsccode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean register() {
		try {
			Scanner sc=new Scanner (System.in);
			System.out.println("Enter the customer ID: ");
			custId=sc.next();
			System.out.println("Enter the Customer Name: ");
			custName=sc.next();
			System.out.println("Enter the Account No: ");
			accno=sc.nextInt();
			System.out.println("Enter the Password: ");
			password=sc.next();
			System.out.println("Enter the amount being deposited: ");
			balance=sc.nextInt();
			System.out.println("Enter the Bank Name: ");
			bankname=sc.next();
			System.out.println("Enter the IFSC code: ");
			ifsccode=sc.next();
			System.out.println("Enter the Email: ");
			email=sc.next();
			
			String query="insert into bankingapp(custId,custName,accno,password,balance,bankname,ifsccode,email)"
					+ "values(?,?,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setString(1,custId);
			pstmt.setString(2, custName);
			pstmt.setInt(3, accno);
			pstmt.setString(4, password);
			pstmt.setInt(5, balance);
			pstmt.setString(6, bankname);
			pstmt.setString(7, ifsccode);
			pstmt.setString(8, email);
			
			int x=pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
		}
	}
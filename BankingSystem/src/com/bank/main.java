package com.bank;

import com.bank.BankAccount;

public class main {

	    public static void main(String[] args) {
	    	
	        // Creating objects (instances) of the BankAccount class
	        BankAccount acc1 = new BankAccount("ACC1001", "Aarav Sharma", 5000);
	        BankAccount acc2 = new BankAccount("ACC1002", "Priya Verma", 2000);
	        BankAccount acc3 = new BankAccount("ACC1003", "Rohan Gupta", 10000);

	     
	        BankAccount[] allAccounts = new BankAccount[3];
	        allAccounts[0] = acc1;
	        allAccounts[1] = acc2;
	        allAccounts[2] = acc3;

	        System.out.println("===== Bank Account Management System =====");

	        // Operating on individual objects
	        acc1.deposit(1500);
	        acc1.withdraw(2000);
	        acc2.deposit(500);
	        acc2.withdraw(5000);      // fail hoga: insufficient funds
	        acc3.transferTo(acc1, 3000);

	        // Printing statements for every account object
	        for (int i = 0; i < allAccounts.length; i++) {
	            allAccounts[i].printStatement();
	        }

	        System.out.println("\n===== Final Account Summary =====");
	        for (int i = 0; i < allAccounts.length; i++) {
	            System.out.println(allAccounts[i]);
	        }
	    }
	}
	
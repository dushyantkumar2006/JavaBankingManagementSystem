package com.bank;
	public class BankAccount {

	    // ----- Fields (state) -----
	    private String accountNumber;
	    private String ownerName;
	    private double balance;
	    private String[] transactionHistory;   
	    private int transactionCount;          
	    
	    // ----- Constructor -----
	    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
	        this.accountNumber = accountNumber;
	        this.ownerName = ownerName;
	        this.balance = openingBalance;
	        this.transactionHistory = new String[50];   // max 50 transactions
	        this.transactionCount = 0;

	        System.out.println("Account opened with balance Rs. " + openingBalance);
	        addTransaction("Account opened with balance Rs. " + openingBalance);
	    }

	    // ----- Behavior (methods) -----
	    public void deposit(double amount) {
	        if (amount <= 0) {
	            System.out.println("Deposit amount must be positive.");
	            return;
	        }
	        balance += amount;
	        System.out.println("Deposited Rs. " + amount);
	        addTransaction("Deposited Rs. " + amount);
	    }

	    public void withdraw(double amount) {
	        if (amount <= 0) {
	            System.out.println("Withdrawal amount must be positive.");
	            return;
	        }
	        if (amount > balance) {
	            System.out.println("Insufficient funds for account " + accountNumber);
	            addTransaction("Failed withdrawal attempt of Rs. " + amount + " (insufficient funds)");
	            return;
	        }
	        balance -= amount;
	        System.out.println("Withdrew Rs. " + amount);
	        addTransaction("Withdrew Rs. " + amount);
	    }

	    public void transferTo(BankAccount other, double amount) {
	        if (amount <= 0) {
	            System.out.println("Transfer amount must be positive.");
	            return;
	        }
	        if (amount > balance) {
	            System.out.println("Transfer failed: insufficient funds in " + accountNumber);
	            return;
	        }
	        this.withdraw(amount);
	        other.deposit(amount);
	        System.out.println("Transferred Rs. " + amount + " to " + other.accountNumber);
	        addTransaction("Transferred Rs. " + amount + " to " + other.accountNumber);
	    }

	    // array me entry add karne ka helper method
	    private void addTransaction(String action) {
	        if (transactionCount < transactionHistory.length) {
	            transactionHistory[transactionCount] = action;
	            transactionCount++;
	        } else {
	            System.out.println("Transaction history full for " + accountNumber);
	        }
	    }

	    public void printStatement() {
	        System.out.println("\n--- Statement for " + accountNumber + " (" + ownerName + ") ---");
	        for (int i = 0; i < transactionCount; i++) {
	            System.out.println("  - " + transactionHistory[i]);
	        }
	        System.out.printf("  Current Balance: Rs. %.2f%n", balance);
	    }

	    // ----- Getters (encapsulation) -----
	    public String getAccountNumber() {
	        return accountNumber;
	    }

	    public String getOwnerName() {
	        return ownerName;
	    }

	    public double getBalance() {
	        return balance;
	    }

	    @Override
	    public String toString() {
	        return String.format("[%s] %s - Balance: Rs. %.2f", accountNumber, ownerName, balance);
	    }
	}
	